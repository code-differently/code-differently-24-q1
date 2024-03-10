package com.codedifferently.lesson7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Lesson7.class)
class Lesson7Test {

  @Test
  void testCanVote() {
    // Test when age is less than the minimum voting age
    assertThat(Lesson7.canVote(17)).isFalse();

    // Test when age is equal to the minimum voting age
    assertThat(Lesson7.canVote(18)).isTrue();

    // Test when age is greater than the minimum voting age
    assertThat(Lesson7.canVote(21)).isTrue();
  }

  @Test
  void testCanVote_ageIsValid() {
    assertThatThrownBy(() -> Lesson7.canVote(-10)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Age must be greater than 0.");
  }

  @Test
  void testCompareStrings() {
    // Test when both strings are equal
    assertThat(Lesson7.compareStrings("hello", "hello")).isEqualTo(0);

    // Test when the first string is less than the second string
    assertThat(Lesson7.compareStrings("apple", "banana")).isEqualTo(-1);

    // Test when the first string is greater than the second string
    assertThat(Lesson7.compareStrings("banana", "apple")).isEqualTo(1);
  }

  @Test
  void testCompareStrings_mustNotBeNull() {
      assertThatThrownBy(() -> Lesson7.compareStrings(null, "test")).isInstanceOf(IllegalArgumentException.class);
      assertThatThrownBy(() -> Lesson7.compareStrings("test", null)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testConvertGpaToLetterGrade() {
    Map<String, String> letterGradeByGpa = new HashMap<String, String>();
    letterGradeByGpa.put("4.0", "A");
    letterGradeByGpa.put("3.99", "A-");
    letterGradeByGpa.put("3.7", "A-");
    letterGradeByGpa.put("3.69", "B+");
    letterGradeByGpa.put("3.3", "B+");
    letterGradeByGpa.put("3.29", "B");
    letterGradeByGpa.put("3.0", "B");
    letterGradeByGpa.put("2.99", "B-");
    letterGradeByGpa.put("2.7", "B-");
    letterGradeByGpa.put("2.69", "C+");
    letterGradeByGpa.put("2.3", "C+");
    letterGradeByGpa.put("2.29", "C");
    letterGradeByGpa.put("2.0", "C");
    letterGradeByGpa.put("1.99", "C-");
    letterGradeByGpa.put("1.7", "C-");
    letterGradeByGpa.put("1.69", "D+");
    letterGradeByGpa.put("1.3", "D+");
    letterGradeByGpa.put("1.29", "D");
    letterGradeByGpa.put("1.00", "D");
    letterGradeByGpa.put("0.99", "F");

    letterGradeByGpa.entrySet().stream()
        .forEach(
            entry ->
                assertThat(Lesson7.convertGpaToLetterGrade(Double.parseDouble(entry.getKey())))
                    .isEqualTo(entry.getValue()));
  }

  @Test
  void testConvertGpaToLetterGrade_validGpaRange() {
      assertThatThrownBy(() -> Lesson7.convertGpaToLetterGrade(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testComputeFactorial() {
    // Test for factorial of 0
    assertThat(Lesson7.computeFactorial(0)).isEqualTo(1);

    // Test for factorial of 5
    assertThat(Lesson7.computeFactorial(5)).isEqualTo(120);

    // Test for factorial of 10
    assertThat(Lesson7.computeFactorial(10)).isEqualTo(3628800);
  }

  @Test
  void testAddNumbers() {
    // Test for an empty array
    assertThat(Lesson7.addNumbers(new double[] {})).isEqualTo(0);

    // Test for an array with positive numbers
    assertThat(Lesson7.addNumbers(new double[] {1.5, 2.5, 3.5})).isEqualTo(7.5);

    // Test for an array with negative numbers
    assertThat(Lesson7.addNumbers(new double[] {-1.5, -2.5, -3.5})).isEqualTo(-7.5);
  }

  @Test
  void testGetFirstNFibonacciNumbers() {
    // Test for n = 0
    assertThat(Lesson7.getFirstNFibonacciNumbers(0)).isEqualTo(new int[] {});

    // Test for n = 5
    assertThat(Lesson7.getFirstNFibonacciNumbers(5)).isEqualTo(new int[] {1, 1, 2, 3, 5});

    // Test for n = 10
    assertThat(Lesson7.getFirstNFibonacciNumbers(10))
        .isEqualTo(new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55});
  }

  @Test
  void testGetFirstNFibonacciNumbers_validateInput() {
    assertThatThrownBy(() -> Lesson7.getFirstNFibonacciNumbers(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testBinarySearch() {
    int[] values = {1, 3, 5, 7, 9};

    // Test for value present in the array
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 1)).isEqualTo(0);
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 3)).isEqualTo(1);
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 5)).isEqualTo(2);
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 7)).isEqualTo(3);
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 9)).isEqualTo(4);

    // Test for value not present in the array
    assertThat(Lesson7.binarySearch(values, 0, values.length - 1, 4)).isEqualTo(-1);
  }

  @Test
  void testBinarySearch_confirmInputSorted() {
      // Arrange
      int[] values = {7, 5, 1};

      // Act
      assertThatThrownBy(() -> Lesson7.binarySearch(values, 0, 0, 10)).isInstanceOf(IllegalArgumentException.class);
  }
}
