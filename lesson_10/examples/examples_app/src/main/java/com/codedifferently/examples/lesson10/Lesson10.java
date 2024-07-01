package com.codedifferently.examples.lesson10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson10 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson10.class);
    application.run(args);
  }
}
