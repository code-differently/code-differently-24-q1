package com.codedifferently.lesson3;

import javax.annotation.Nonnull;

public class QuizPrinter {

  public void printQuiz(@Nonnull Iterable<QuizQuestion> quizQuestions) {
    System.out.println();

    for (QuizQuestion question : quizQuestions) {
      printQuizQuestion(question);
    }
  }

  private void printQuizQuestion(QuizQuestion question) {
    System.out.println(
        "Question " + question.getQuestionNumber() + ": " + question.getQuestionPrompt());

    if (question instanceof MultipleChoiceQuizQuestion) {
      printPossibleAnswers((MultipleChoiceQuizQuestion) question);
    }

    System.out.println(">> Your answer: " + question.getAnswer());
    System.out.println();
  }

  private void printPossibleAnswers(MultipleChoiceQuizQuestion question) {
    for (AnswerChoice option : AnswerChoice.values()) {
      if (option == AnswerChoice.UNANSWERED) {
        continue;
      }
      System.out.println(option + ": " + question.getAnswerForOption(option));
    }
  }
}
