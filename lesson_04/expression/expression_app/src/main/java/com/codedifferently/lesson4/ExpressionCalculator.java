package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /** Returns the calculation of ((a + b) * c) / d^e */
  public double calculate(double a, double b, double c, double d, double e) {
    // Implement your code here to return the correct value.
    double addTotal = add(a, b);
    double productTotal = multiply(addTotal, c);
    double powTotal = pow(d, e);
    double quotientTotal = divide(productTotal, powTotal);
    return quotientTotal;
  }

  // addition function
  public double add(double a, double b) {
    double sum = a + b;
    return sum;
  }

  // multiply function
  public double multiply(double sum, double c) {
    double product = sum * c;
    return product;
  }

  // divide function
  public double divide(double numerator, double denominator) {
    double quotient = numerator / denominator;
    return quotient;
  }

  // expotential function
  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
