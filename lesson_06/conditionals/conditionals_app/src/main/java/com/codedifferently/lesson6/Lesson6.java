package com.codedifferently.lesson6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson6 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson6.class);
    application.run(args);
  }

  public void run(String... args) throws Exception {}
}
