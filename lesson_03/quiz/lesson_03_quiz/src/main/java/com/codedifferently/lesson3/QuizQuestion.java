package com.codedifferently.lesson3;

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
    return correctAnswer;
  }
}
