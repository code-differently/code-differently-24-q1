package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /** Returns the calculation of ((a + b) * c) / d^e */
  public double calculate(double a, double b, double c, double d, double e) {
    double output = ((a + b) * c) / pow(d, e);
    return output;
  }

  public double add(double a, double b) {
    double sum = a + b;
    return sum;
  }

  public double multiply(double a, double b) {
    double product = a * b;
    return product;
  }

  public double divide(double a, double b) {
    double quotient = a / b;
    return quotient;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
