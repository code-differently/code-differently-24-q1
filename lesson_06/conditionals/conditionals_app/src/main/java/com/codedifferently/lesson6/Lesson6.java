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
    // The distance will be a number less than 0 if string `a` is lexographically less than `b`, 1
    // if it is greater, and 0 if the strings are equal.
    int distance = Helpers.computeLexographicDistance(a, b);

    // TODO(you): Finish this method.

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
    return "F";
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
    return 0;
  }

  /**
   * Returns an array of the first `n` fibonacci numbers starting from 1.
   *
   * @param n The first `n` of fibonacci values to compute.
   * @return An array containing the first `n` fibonacci values.
   */
  public static int[] getFirstNFibonacciNumbers(int n) {
    return null;
  }

  /**
   * Finds a value in an array of values.
   *
   * @param values The values to search.
   * @param The left most index to search.
   * @param The right most index to search.
   * @param value The value to look for.
   * @return The index of the value if found in the array and -1 otherwise.
   */
  public static int binarySearch(int[] values, int start, int end, int value) {
    if (end < start) {
      // The range is not valid so just return -1.
      return -1;
    }

    int pivotIndex = (start + end) / 2; // The index in the middle of the array.

    // TODO(you): Finish implementing this algorithm

    // If values[pivotIndex] is equal to value then return `pivotIndex`.
    // Else if values[pivotIndex] is greater than the value, then
    // call `binarySearch(values, start, pivotIndex - 1, value)` and return its value;
    // Else call `binarySearch(values, pivotIndex + 1, end, value)` and return its value.
    return -1;
  }
}
