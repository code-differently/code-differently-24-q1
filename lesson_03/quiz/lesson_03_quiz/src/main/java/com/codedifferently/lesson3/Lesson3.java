package com.codedifferently.lesson3;

import com.codedifferently.instructional.quiz.QuizPrinter;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson3 implements CommandLineRunner {

  @Autowired private List<QuizQuestionProvider> quizQuestionProviders;

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson3.class);
    application.run(args);
  }

  public void run(String... args) {
    for (QuizQuestionProvider provider : quizQuestionProviders) {
      System.out.println("\nQuestions by " + provider.getProviderName() + ":");
      printQuiz(provider.makeQuizQuestions());
    }
  }

  public void printQuiz(List<QuizQuestion> quizQuestions) {
    Objects.requireNonNull(quizQuestions);
    var printer = new QuizPrinter();
    printer.printQuiz(quizQuestions);
  }
}
