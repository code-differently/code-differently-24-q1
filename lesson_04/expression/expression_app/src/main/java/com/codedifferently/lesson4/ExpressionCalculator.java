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
    return divide(multiply(add(a, b), c), pow(d, e));
  }

  public double add(double z, double y) {
    double sum = z + y;
    return sum;
  }

  public double multiply(double z, double y) {
    double product = z * y;
    return product;
  }

  public double divide(double z, double y) {
    double quotient = z / y;
    return quotient;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
