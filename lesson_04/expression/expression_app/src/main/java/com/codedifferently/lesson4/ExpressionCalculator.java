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
    double sum = add(a, b);
    double result = (sum * c) / pow(d, e);
    return result;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double add(double a, double b) {
    double sum = a + b;
    return sum;
  }

  public double multiply(double a, double b) {
    double factor = a * b;
    return factor;
  }

  public double divide(double a, double b) {
    double quotient = a / b;
    return quotient;
  }
}
