package com.codedifferently.lesson4;

import javax.annotation.Nonnull;

public class QuizPrinter {

  public void printQuiz(@Nonnull QuizQuestion[] quizQuestions) {
    System.out.println();

    for (QuizQuestion question : quizQuestions) {
      printQuizQuestion(question);
    }
  }

  private void printQuizQuestion(QuizQuestion question) {
    System.out.println("Question " + question.getQuestionNumber() + ": " + question.getQuestion());

    printPossibleAnswers(question);

    System.out.println(">> Your answer: " + question.getAnswer());
    System.out.println();
  }

  private void printPossibleAnswers(QuizQuestion question) {
    for (AnswerOption option : AnswerOption.values()) {
      if (option == AnswerOption.UNANSWERED) {
        continue;
      }
      System.out.println(option + ": " + question.getAnswerForOption(option));
    }
  }
}
