package com.codedifferently.lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson6 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson6.class);
    application.run(args);
  }

  /**
   * Returns true if the provided age meets the minimum US voting age and false otherwise.
   *
   * @param age The age to check.
   * @return True if the age corresponds to a voting age and false otherwise.
   */
  public static boolean canVote(int age) {
    return false;
  }

  /**
   * Compares two strings lexographically.
   *
   * @param value1 The first `String` to compare.
   * @param value2 The second `String` to compare.
   * @rerturn -1 if a is less than b, 1 if a is greater than b, and 0 otherwise.
   */
  public static int compareStrings(String a, String b) {
    return 0;
  }

  /**
   * Converts a GPA on the 4.0 scale to the corresponding letter grade using the college board
   * scale. See
   * https://bigfuture.collegeboard.org/plan-for-college/college-basics/how-to-convert-gpa-4.0-scale
   * for details.
   *
   * @param gpa The GPA value.
   * @return The letter grade ("A+", "A", "A-", "B+", etc.).
   */
  public static String convertGpaToLetterGrade(double gpa) {
    return "A+";
  }

  /**
   * Computes the factorial of the given value of `n`.
   *
   * @param n The value for which to compute the factorial.
   * @return The factorial of n.
   */
  public static int computeFactorial(int n) {
    return 0;
  }

  /**
   * Adds all of the provided values and returns the sum.
   *
   * @param values The values to sum.
   * @return The sum of all the values.
   */
  public static double addNumbers(double[] values) {
    return 0d;
  }

  /**
   * Returns an array of the first `n` fibonacci numbers starting from 1.
   *
   * @param n The first `n` of fibonacci values to compute.
   * @return An array containing the first `n` fibonacci values.
   */
  public static int[] getFirstNFibonacciNumbers(int n) {
    return new int[] {};
  }
}
