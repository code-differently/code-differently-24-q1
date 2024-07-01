package com.codedifferently.lesson4;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson4 implements CommandLineRunner {

  public static void main(String[] args) {
    // To test, use `./gradlew run --console=plain`
    var application = new SpringApplication(Lesson4.class);
    application.run(args);
  }

  public void run(String... args) {
    // Use Scanner to get input from the user.
    var scanner = new Scanner(System.in);

    System.out.print("\nEnter a value for variable 'a': ");
    int a = scanner.nextInt();

    System.out.print("Enter a value for variable 'b': ");
    int b = scanner.nextInt();

    System.out.print("Enter a value for variable 'c': ");
    int c = scanner.nextInt();

    System.out.print("Enter a value for variable 'd': ");
    int d = scanner.nextInt();

    System.out.print("Enter a value for variable 'e': ");
    int e = scanner.nextInt();

    // Close the scanner to avoid memory leaks.
    scanner.close();

    System.out.println(
        String.format("\nNow computing the value of ((%s + %s) * %s) / %s^%s", a, b, c, d, e));

    var calculator = new ExpressionCalculator();
    double result = calculator.calculate(a, b, c, d, e);

    System.out.println(String.format("The result is: %s", result));
  }
}
