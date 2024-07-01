package com.codedifferently.lesson4;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
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
    var expected = ((a + b) * c) / Math.pow(d, e);

    // Act
    double actual = calculator.calculate(a, b, c, d, e);

    // Assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testAdd_works() throws Exception {
    // Arrange
    Method method = calculator.getClass().getDeclaredMethod("add", double.class, double.class);

    // Act
    var result = (double) method.invoke(calculator, 1, 2);

    // Assert
    assertThat(result).isEqualTo(3);
  }

  @Test
  void testMultipy_works() throws Exception {
    // Arrange
    Method method = calculator.getClass().getDeclaredMethod("multiply", double.class, double.class);

    // Act
    var result = (double) method.invoke(calculator, 1, 2);

    // Assert
    assertThat(result).isEqualTo(2);
  }

  @Test
  void testDivide_works() throws Exception {
    // Arrange
    Method method = calculator.getClass().getDeclaredMethod("divide", double.class, double.class);

    // Act
    var result = (double) method.invoke(calculator, 1, 2);

    // Assert
    assertThat(result).isEqualTo(0.5d);
  }

  @Test
  void testPow_works() throws Exception {
    // Arrange
    Method method = calculator.getClass().getDeclaredMethod("pow", double.class, double.class);

    // Act
    var result = (double) method.invoke(calculator, 2, 3);

    // Assert
    assertThat(result).isEqualTo(8);
  }
}
