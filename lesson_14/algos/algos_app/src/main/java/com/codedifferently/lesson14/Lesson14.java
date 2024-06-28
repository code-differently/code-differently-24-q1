package com.codedifferently.lesson14;

public class Lesson14 {

  public static void main(String[] args) {
    System.out.println("The permutations of 'abc' are:");
    printPermutations("abc", "");

    System.out.println();
    System.out.print("The reverse of 'abc' is: ");
    System.out.println(reverseString("abc"));
  }

  /**
   * Prints all the permutations of a string.
   *
   * @param value The string to permute.
   * @param answer The current permutation.
   */
  public static void printPermutations(String value, String answer) {
    if (value.length() == 0) {
      System.out.println(answer);
      return;
    }

    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      String left = value.substring(0, i);
      String right = value.substring(i + 1);
      String rest = left + right;
      printPermutations(rest, answer + ch);
    }
  }

  /**
   * Reverses a string by swapping the front half of the characters with the back half.
   *
   * @param input The string to reverse.
   * @return The reversed string.
   */
  public static String reverseString(String input) {
    if (input.length() == 0) {
      return input;
    }

    char[] charArray = input.toCharArray();

    for (int i = 0; i < charArray.length / 2; i++) {
      // Compute the corresponding index from the back of the string.
      var j = charArray.length - i - 1;
      swapCharacters(charArray, i, j);
    }

    return new String(charArray);
  }

  /**
   * Swaps the characters in the provided character array.
   *
   * @param charArray
   * @param i
   * @param j
   */
  private static void swapCharacters(char[] charArray, int i, int j) {
    Character temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
  }
}
