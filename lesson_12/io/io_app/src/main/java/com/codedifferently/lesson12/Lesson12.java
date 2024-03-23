package com.codedifferently.lesson12;

import com.codedifferently.lesson12.library.Library;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson12 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson12.class);
    application.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    Library library = LibraryLoader.loadLibrary();
  }
}
