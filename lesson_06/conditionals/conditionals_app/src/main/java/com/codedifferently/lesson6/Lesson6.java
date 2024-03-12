package com.codedifferently.lesson6;

import com.codedifferently.lesson6.util.Helpers;
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

  }

  /**
   * Computes the factorial of the given value of `n`.
   *
   * @param n The value for which to compute the factorial.
   * @return The factorial of n.
   */
  public static int computeFactorial(int n) {

  }

  /**
   * Adds all of the provided values and returns the sum.
   *
   * @param values The values to sum.
   * @return The sum of all the values.
   */
  public static double addNumbers(double[] values) {

  }

  /**
   * Finds a value in an array of values.
   *
   * @param values The values to search.

   * @param value The value to look for.
   * @return The index of the value if found in the array and -1 otherwise.
   */
  public static int binarySearch(int[] values, int start, int end, int value) {

