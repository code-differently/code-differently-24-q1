package com.codedifferently.lesson4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.instructional.quiz.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lesson4Test {

  private ExpressionCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new ExpressionCalculator();
  }

  @Test
  void testCalculate() {
    // Arrange
    var a = 1;
    var b = 2;
    var c = 3;
    var d = 4;
    var e = 5;
    var expected = ((a + b) * c) / (d ^ e);

    // Act
    double actual = calculator.calculate(a, b, c, d, e);

    // Assert
    assertThat(actual).isEqualTo(expected);
  }
}
