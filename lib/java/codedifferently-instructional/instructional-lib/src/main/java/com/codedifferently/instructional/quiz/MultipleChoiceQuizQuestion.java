package com.codedifferently.instructional.quiz;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MultipleChoiceQuizQuestion extends QuizQuestion {

  private Map<AnswerChoice, String> answersByOption;

  public MultipleChoiceQuizQuestion(
      int questionNumber,
      String question,
      Map<AnswerChoice, String> answerOptions,
      AnswerChoice correctAnswer) {

    super(questionNumber, question, correctAnswer.toString());
    this.answersByOption = answerOptions;
  }

  public String getAnswerForOption(AnswerChoice option) {
    return answersByOption.get(option);
  }

  @Override
  public void promptForAnswer(Scanner scanner) {
    String response = null;
    Optional<AnswerChoice> answer = Optional.empty();

    do {
      // If a response was given but not accepted, announce that.
      if (response != null) {
        System.out.println("Value not accepted, try again.\n");
      }

      // Get a response.
      System.out.print(">> Your answer (or 's' to skip): ");
      response = scanner.next().toUpperCase().trim();

      // If the user wants to skip, let them.
      if (response.equals("S")) {
        this.setAnswer(null);
        return;
      }

      // Try to parse the answer.
      answer = AnswerChoice.valueOrEmpty(response);
    } while (answer.isEmpty());

    // Set the question answer.
    this.setAnswer(answer.get().toString());
  }
}
