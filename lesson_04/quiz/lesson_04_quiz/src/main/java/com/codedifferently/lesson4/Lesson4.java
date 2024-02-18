package com.codedifferently.lesson4;

import java.util.Map;

public class Lesson4 {

  public static void main(String[] args) {
    QuizQuestion[] quizQuestions = makeQuizQuestions();
    var printer = new QuizPrinter();
    printer.printQuiz(quizQuestions);
  }

  public static QuizQuestion[] makeQuizQuestions() {
    return new QuizQuestion[] {
      makeQuestion0(),
      makeQuestion1(),
      makeQuestion2(),
      makeQuestion3(),
      makeQuestion4(),
      makeQuestion5()
    };
  }

  private static QuizQuestion makeQuestion0() {
    return new QuizQuestion(
        0,
        "If your computer doesn't turn on, what is the first thing you should check?",
        Map.of(
            AnswerOption.A, "The power supply",
            AnswerOption.B, "The monitor",
            AnswerOption.C, "The keyboard",
            AnswerOption.D, "The mouse"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1,
        "Which part of the computer is responsible for processing data?",
        Map.of(
            AnswerOption.A, "The power supply",
            AnswerOption.B, "The keyboard",
            AnswerOption.C, "The CPU",
            AnswerOption.D, "RAM"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion2() {
    return new QuizQuestion(
        2,
        "This part of the computer is like the CPU, but handles graphics computations.",
        Map.of(
            AnswerOption.A, "The monitor",
            AnswerOption.B, "The GPU",
            AnswerOption.C, "RAM",
            AnswerOption.D, "The motherboard"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion3() {
    return new QuizQuestion(
        3,
        "The CPU uses what part of the computer to store and execute instructions?",
        Map.of(
            AnswerOption.A, "The power supply",
            AnswerOption.B, "The keyboard",
            AnswerOption.C, "RAM",
            AnswerOption.D, "The GPU"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion4() {
    return new QuizQuestion(
        4,
        "What components are hard drives and solid state drives (SSD) classified as?",
        Map.of(
            AnswerOption.A, "Motherboards",
            AnswerOption.B, "Storage devices",
            AnswerOption.C, "RAM",
            AnswerOption.D, "CPU"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion5() {
    return new QuizQuestion(
        5,
        "This part of the computer is like the human body's central nervous system:",
        Map.of(
            AnswerOption.A, "Motherboard",
            AnswerOption.B, "Storage",
            AnswerOption.C, "RAM",
            AnswerOption.D, "CPU"),
        AnswerOption.UNANSWERED); // Replace `UNANSWERED` with the correct answer
  }
}
