package com.codedifferently.lesson2;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizPrinter;
import com.codedifferently.instructional.quiz.QuizQuestion;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson2 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson2.class);
    application.run(args);
  }

  public void run(String... args) {
    List<QuizQuestion> quizQuestions = makeQuizQuestions();
    Objects.requireNonNull(quizQuestions);
    var printer = new QuizPrinter();
    printer.printQuiz(quizQuestions);
  }

  public static List<QuizQuestion> makeQuizQuestions() {
    return List.of(
        makeQuestion0(),
        makeQuestion1(),
        makeQuestion2(),
        makeQuestion3(),
        makeQuestion4(),
        makeQuestion5(),
        makeQuestion6(),
        makeQuestion7(),
        makeQuestion8(),
        makeQuestion9(),
        makeQuestion10());
  }

  private static QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "If your computer doesn't turn on, what is the first thing you should check?",
        Map.of(
            AnswerChoice.A, "The power supply",
            AnswerChoice.B, "The monitor",
            AnswerChoice.C, "The keyboard",
            AnswerChoice.D, "The mouse"),
        AnswerChoice.A); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Which part of the computer is responsible for processing data?",
        Map.of(
            AnswerChoice.A, "The power supply",
            AnswerChoice.B, "The keyboard",
            AnswerChoice.C, "The CPU",
            AnswerChoice.D, "RAM"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer
  }

  private static QuizQuestion makeQuestion2() {
    return new MultipleChoiceQuizQuestion(
        2,
        "This part of the computer is like the CPU, but handles graphics computations.",
        Map.of(
            AnswerChoice.A, "The monitor",
            AnswerChoice.B, "The GPU",
            AnswerChoice.C, "RAM",
            AnswerChoice.D, "The motherboard"),
        AnswerChoice.B); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion3() {
    return new MultipleChoiceQuizQuestion(
        3,
        "The CPU uses what part of the computer to store and execute instructions?",
        Map.of(
            AnswerChoice.A, "The power supply",
            AnswerChoice.B, "The keyboard",
            AnswerChoice.C, "RAM",
            AnswerChoice.D, "The GPU"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion4() {
    return new MultipleChoiceQuizQuestion(
        4,
        "What components are hard drives and solid state drives (SSD) classified as?",
        Map.of(
            AnswerChoice.A, "Motherboards",
            AnswerChoice.B, "Storage devices",
            AnswerChoice.C, "RAM",
            AnswerChoice.D, "CPU"),
        AnswerChoice.B); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion5() {
    return new MultipleChoiceQuizQuestion(
        5,
        "This part of the computer is like the human body's central nervous system:",
        Map.of(
            AnswerChoice.A, "Motherboard",
            AnswerChoice.B, "Storage",
            AnswerChoice.C, "RAM",
            AnswerChoice.D, "CPU"),
        AnswerChoice.A); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion6() {
    return new QuizQuestion(
        6,
        "What is the decimal number 34 in binary?",
        "0b00100010"); // Replace the correct digits in the answer.
  }

  private static QuizQuestion makeQuestion7() {
    return new QuizQuestion(
        7,
        "What is the decimal number 34 in hex?",
        "0x22"); // Replace the correct digits in the answer.
  }

  private static QuizQuestion makeQuestion8() {
    return new QuizQuestion(
        8,
        "What is binary number 0b01100101 in decimal?",
        "101"); // Specify the correct number (no leading zeros).
  }

  private static QuizQuestion makeQuestion9() {
    return new MultipleChoiceQuizQuestion(
        9,
        "What git command can you use to create a new branch?",
        Map.of(
            AnswerChoice.A, "git checkout <branch-name>",
            AnswerChoice.B, "git pull <branch-name>",
            AnswerChoice.C, "git checkout -b <branch-name>",
            AnswerChoice.D, "git push <branch-name>"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer.
  }

  private static QuizQuestion makeQuestion10() {
    return new MultipleChoiceQuizQuestion(
        10,
        "What is the difference between a fork and a branch in git?",
        Map.of(
            AnswerChoice.A, "You cannot push changes to a fork",
            AnswerChoice.B, "There is no difference since everything is a branch to git",
            AnswerChoice.C, "A fork requires an upstream remote whereas a branch does not",
            AnswerChoice.D, "You can only make pull requests using a branch"),
        AnswerChoice.B); // Replace `UNANSWERED` with the correct answer.
  }
}
