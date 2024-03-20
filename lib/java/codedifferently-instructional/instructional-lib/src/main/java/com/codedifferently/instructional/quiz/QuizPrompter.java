package com.codedifferently.instructional.quiz;

import java.util.List;
import java.util.Scanner;

public class QuizPrompter {
  private Scanner scanner;
  private QuizPrinter printer = new QuizPrinter();

  public QuizPrompter(Scanner scanner) {
    this.scanner = scanner;
  }

  public void setQuizPrinter(QuizPrinter printer) {
    this.printer = printer;
  }

  public void promptForAnswers(List<QuizQuestion> questions) {
    var scanner = new Scanner(System.in);
    for (QuizQuestion question : questions) {
      promptForAnswer(scanner, question);
    }
  }

  private void promptForAnswer(Scanner scanner, QuizQuestion question) {
    this.printer.printQuizQuestion(question, false);
    question.promptForAnswer(scanner);
  }
}
