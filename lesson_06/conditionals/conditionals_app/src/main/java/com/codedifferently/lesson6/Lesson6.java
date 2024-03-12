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
    return age >= 18;
  }

  /**
   * Compares two strings lexicographically.
   *
   * @param value1 The first `String` to compare.
   * @param value2 The second `String` to compare.
   * @return -1 if value1 is less than value2, 1 if value1 is greater than value2, and 0 otherwise.
   */
  public static int compareStrings(String value1, String value2) {
    int distance = Helpers.computeLexographicDistance(value1, value2);
    if (distance < 0) {
      return -1;
    } else if (distance > 0) {
      return 1;
    } else {
      return 0;
    }
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
    if (gpa >= 4.0) {
      return "A";
    } else if (gpa >= 3.7) {
      return "A-";
    } else if (gpa >= 3.3) {
      return "B+";
    } else if (gpa >= 3.0) {
      return "B";
    } else if (gpa >= 2.7) {
      return "B-";
    } else if (gpa >= 2.3) {
      return "C+";
    } else if (gpa >= 2.0) {
      return "C";
    } else if (gpa >= 1.7) {
      return "C-";
    } else if (gpa >= 1.3) {
      return "D+";
    } else if (gpa >= 1.0) {
      return "D";
    } else {
      return "F";
    }
  }

  /**
   * Computes the factorial of the given value of `n`.
   *
   * @param n The value for which to compute the factorial.
   * @return The factorial of n.
   */
  public static int computeFactorial(int n) {
    if (n == 0) {
      return 1;
    }
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  /**
   * Adds all of the provided values and returns the sum.
   *
   * @param values The values to sum.
   * @return The sum of all the values.
   */
  public static double addNumbers(double[] values) {
    double sum = 0;
    for (double value : values) {
      sum += value;
    }
    return sum;
  }

  /**
   * Returns an array of the first `n` Fibonacci numbers starting from 1.
   *
   * @param n The first `n` of Fibonacci values to compute.
   * @return An array containing the first `n` Fibonacci values.
   */
  public static int[] getFirstNFibonacciNumbers(int n) {
    if (n <= 0) {
      return new int[0];
    } else if (n == 1) {
      return new int[] {1};
    } else {
      int[] fib = new int[n];
      fib[0] = 1;
      fib[1] = 1;
      for (int i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
      }
      return fib;
    }
  }

  /**
   * Finds a value in an array of values.
   *
   * @param values The values to search.
   * @param start The left most index to search.
   * @param end The right most index to search.
   * @param value The value to look for.
   * @return The index of the value if found in the array and -1 otherwise.
   */
  public static int binarySearch(int[] values, int start, int end, int value) {
    if (end >= start) {
      int mid = start + (end - start) / 2;
      if (values[mid] == value) {
        return mid;
      }
      if (values[mid] > value) {
        return binarySearch(values, start, mid - 1, value);
      }
      return binarySearch(values, mid + 1, end, value);
    }
    return -1;
  }
}
