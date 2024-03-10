package com.codedifferently.lesson6.util;

public class Helpers {
  /**
   * Computes a score describing the lexographic distance between two strings. For two strings of
   * equal length, the score will be the difference between the first differing character. In the
   * case where either is a sub-string of the other, then the difference in length determines the
   * score.
   *
   * @param a The first string to compare.
   * @param b The second string to compare.
   * @return A score representing the lexographic distance between two strings.
   */
  public static int computeLexographicDistance(String a, String b) {
    for (var i = 0; i < a.length(); ++i) {
      if (a.charAt(i) == b.charAt(i)) {
        continue;
      }
      return (int) a.charAt(i) - (int) b.charAt(i);
    }

    if (a.length() != b.length()) {
      return a.length() - b.length();
    }

    return 0;
  }
}
