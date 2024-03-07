package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   *
   * @param a
   * @param b
   * @return
   */
  public double add(double a, double b) {
    return a + b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double divide(double numerator, double denominator) {
    return numerator / denominator;
  }

  public double calculate(double a, double b, double c, double d, double e) {
    double sum = add(a, b);
    double multiplication = multiply(sum, c);
    double exponential = pow(d, e);
    return divide(multiplication, exponential);
  }
}
