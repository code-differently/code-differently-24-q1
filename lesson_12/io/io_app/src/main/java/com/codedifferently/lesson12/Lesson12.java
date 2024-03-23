package com.codedifferently.lesson12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson12 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson12.class);
    application.run(args);
  }
}
