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
    double sum = add(a, b);
    double product = multiply(sum, c);
    double powTotal = pow(d, e);
    double quotient = divide(product, powTotal);
    return quotient;
  }

  // Step 1. add a & b
  public double add(double a, double b) {
    return a + b;
  }

  // Step 2. multiply the sum of ab by c
  public double multiply(double x, double y) {
    return x * y;
  }

  // Step 3. divide product by exponent total
  public double divide(double numerator, double denominator) {
    return numerator / denominator;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
