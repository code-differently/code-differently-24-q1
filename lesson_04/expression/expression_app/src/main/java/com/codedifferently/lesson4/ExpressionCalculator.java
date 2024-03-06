package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   *
   * @param a
   * @param b
   * @return
   */
  public double calculate(double a, double b, double c, double d, double e) {
    // Implement your code here to return the correct value.
    double sum = ((a + b) * c) / pow(d, e);
    return sum;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
