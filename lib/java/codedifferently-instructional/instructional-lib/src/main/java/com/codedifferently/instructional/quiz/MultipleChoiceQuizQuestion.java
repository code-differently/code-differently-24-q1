package com.codedifferently.instructional.quiz;

import java.util.Map;

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
}
