package com.codedifferently.lesson6;

import com.codedifferently.lesson6.util.Helpers;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson6 {

  public static void main(String[] args) {
    SpringApplication.run(Lesson6.class, args);
  }

  public static boolean canVote(int age) {
    return age >= 18;
  }

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
   * Converts a GPA on the 4.0 scale to the corresponding letter grade.
   *
   * @param gpa The GPA value.
   * @return The letter grade ("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", or
   *     "F").
   */
  public static String convertGpaToLetterGrade(double gpa) {
    if (gpa >= 4.0) return "A";
    if (gpa >= 3.7) return "A-";
    if (gpa >= 3.3) return "B+";
    if (gpa >= 3.0) return "B";
    if (gpa >= 2.7) return "B-";
    if (gpa >= 2.3) return "C+";
    if (gpa >= 2.0) return "C";
    if (gpa >= 1.7) return "C-";
    if (gpa >= 1.3) return "D+";
    if (gpa >= 1.0) return "D";
    return "F";
  }

  public static int computeFactorial(int n) {
    return n == 0 ? 1 : n * computeFactorial(n - 1);
  }

  public static double addNumbers(double[] values) {
    return Arrays.stream(values).sum();
  }

  public static int[] getFirstNFibonacciNumbers(int n) {
    if (n < 1) return new int[0]; // Handle cases where n < 1
    int[] fib = new int[n];
    fib[0] = 1;
    if (n > 1) {
      fib[1] = 1;
      for (int i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
      }
    }
    return fib;
  }

  public static int binarySearch(int[] values, int value) {
    return binarySearch(values, 0, values.length - 1, value);
  }

  public static int binarySearch(int[] values, int start, int end, int value) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (values[mid] == value) {
        return mid;
      } else if (values[mid] < value) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
