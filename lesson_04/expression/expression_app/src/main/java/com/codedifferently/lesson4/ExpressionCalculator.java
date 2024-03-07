package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /** Returns the calculation of ((a + b) * c) / d^e */
  // Method to add two numbers

  public double calculate(double a, double b, double c, double d, double e) {
    double sum = add(a, b);

    double product = multiply(sum, c);

    double dToThePowerOfE = pow(d, e);

    return divide(product, dToThePowerOfE);
  }

  public double add(double number1, double number2) {
    return number1 + number2;
  }

  public double multiply(double number1, double number2) {
    return number1 * number2;
  }

  public double divide(double numerator, double denominator) {
    return numerator / denominator;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
