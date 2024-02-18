package com.codedifferently.lesson3;

import java.util.Map;

public class QuizQuestion {

  private int questionNumber;

  private String question;

  private Map<AnswerOption, String> answersByOption;

  private AnswerOption correctAnswer;

  public QuizQuestion(
      int questionNumber,
      String question,
      Map<AnswerOption, String> answerOptions,
      AnswerOption correctAnswer) {
    this.questionNumber = questionNumber;
    this.question = question;
    this.answersByOption = answerOptions;
    this.correctAnswer = correctAnswer;
  }

  public int getQuestionNumber() {
    return questionNumber;
  }

  public String getQuestionPrompt() {
    return question;
  }

  public String getAnswerForOption(AnswerOption option) {
    return answersByOption.get(option);
  }

  public AnswerOption getAnswer() {
    return correctAnswer;
  }
}
