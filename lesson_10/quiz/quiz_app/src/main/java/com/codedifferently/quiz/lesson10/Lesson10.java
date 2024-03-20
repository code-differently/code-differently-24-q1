package com.codedifferently.quiz.lesson10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import com.codedifferently.instructional.quiz.QuizConfig;
import org.springframework.boot.CommandLineRunner;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson10 implements CommandLineRunner {
  @Autowired
  private QuizConfig quizConfig;

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson10.class);
    application.run(args);
  }

  public void run(String... args) {
      System.out.println("choices are" + quizConfig.getQuestions("default").get(0));
  }
}
