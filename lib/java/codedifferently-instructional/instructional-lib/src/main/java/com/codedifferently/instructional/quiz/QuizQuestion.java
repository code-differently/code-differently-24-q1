package com.codedifferently.instructional.quiz;

import java.util.Objects;
import java.util.Scanner;

public class QuizQuestion {

  private int questionNumber;

  private String question;

  private String correctAnswer;

  public QuizQuestion(int questionNumber, String question, String correctAnswer) {
    this.questionNumber = questionNumber;
    this.question = question;
    this.correctAnswer = correctAnswer;
  }

  public int getQuestionNumber() {
    return questionNumber;
  }

  public String getQuestionPrompt() {
    return question;
  }

  public String getAnswer() {
    return Objects.toString(correctAnswer, "");
  }

  public void setAnswer(String answer) {
    this.correctAnswer = answer;
  }

  public void promptForAnswer(Scanner scanner) {
    String response = null;

    do {
      // If a response was given but not accepted, announce that.
      if (response != null) {
        System.out.println("Value not accepted, try again.\n");
      }

      // Get a response.
      System.out.print(">> Your answer (or 's' to skip): ");
      response = scanner.next().trim();

      // If the user wants to skip, let them.
      if (response.toUpperCase().equals("S")) {
        this.setAnswer(null);
        return;
      }
    } while (response.equals(""));

    // Set the question answer.
    this.setAnswer(response);
  }
}
