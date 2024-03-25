package com.codedifferently.lesson12;

import com.codedifferently.lesson12.cli.LibraryApp;
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
    // Don't run as an app if we're running as a JUnit test.
    if (isJUnitTest()) {
      return;
    }

    new LibraryApp().run(args);
  }

  private static boolean isJUnitTest() {
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      if (element.getClassName().startsWith("org.junit.")) {
        return true;
      }
    }
    return false;
  }
}
