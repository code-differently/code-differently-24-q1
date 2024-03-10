package com.codedifferently.lesson6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Lesson6.class)
class Lesson6Test {

  @Test
  void testCanVote() {
    // Test when age is less than the minimum voting age
    assertThat(Lesson6.canVote(17)).isFalse();

    // Test when age is equal to the minimum voting age
    assertThat(Lesson6.canVote(18)).isTrue();

    // Test when age is greater than the minimum voting age
    assertThat(Lesson6.canVote(21)).isTrue();
  }

  @Test
  void testCompareStrings() {
    // Test when both strings are equal
    assertThat(Lesson6.compareStrings("hello", "hello")).isEqualTo(0);

    // Test when the first string is less than the second string
    assertThat(Lesson6.compareStrings("apple", "banana")).isEqualTo(-1);

    // Test when the first string is greater than the second string
    assertThat(Lesson6.compareStrings("banana", "apple")).isEqualTo(1);
  }

  @Test
  void testConvertGpaToLetterGrade() {
    // Test for GPA 4.0
    assertThat(Lesson6.convertGpaToLetterGrade(4.0)).isEqualTo("A");

    // Test for GPA 3.5
    assertThat(Lesson6.convertGpaToLetterGrade(3.5)).isEqualTo("B+");

    // Test for GPA 2.7
    assertThat(Lesson6.convertGpaToLetterGrade(2.7)).isEqualTo("B-");
  }

  @Test
  void testComputeFactorial() {
    // Test for factorial of 0
    assertThat(Lesson6.computeFactorial(0)).isEqualTo(1);

    // Test for factorial of 5
    assertThat(Lesson6.computeFactorial(5)).isEqualTo(120);

    // Test for factorial of 10
    assertThat(Lesson6.computeFactorial(10)).isEqualTo(3628800);
  }

  @Test
  void testAddNumbers() {
    // Test for an empty array
    assertThat(Lesson6.addNumbers(new double[] {})).isEqualTo(0);

    // Test for an array with positive numbers
    assertThat(Lesson6.addNumbers(new double[] {1.5, 2.5, 3.5})).isEqualTo(7.5);

    // Test for an array with negative numbers
    assertThat(Lesson6.addNumbers(new double[] {-1.5, -2.5, -3.5})).isEqualTo(-7.5);
  }

  @Test
  void testGetFirstNFibonacciNumbers() {
    // Test for n = 0
    assertThat(Lesson6.getFirstNFibonacciNumbers(0)).isEqualTo(new int[] {});

    // Test for n = 5
    assertThat(Lesson6.getFirstNFibonacciNumbers(5)).isEqualTo(new int[] {1, 1, 2, 3, 5});

    // Test for n = 10
    assertThat(Lesson6.getFirstNFibonacciNumbers(10))
        .isEqualTo(new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55});
  }

  @Test
  void testBinarySearch() {
    int[] values = {1, 3, 5, 7, 9};

    // Test for value present in the array
    assertThat(Lesson6.binarySearch(values, 0, values.length - 1, 5)).isEqualTo(2);

    // Test for value not present in the array
    assertThat(Lesson6.binarySearch(values, 0, values.length - 1, 4)).isEqualTo(-1);
  }
}
