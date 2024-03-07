package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**  
   * Returns the calculation of ((a + b) * c) / d^e
   */
  public double calculate(double a, double b, double c, double d, double e) {
    // Implement your code here to return the correct value.
    double sum = add(a, b);
    double times = multiply(sum, c);
    double power = pow(d, e);
    double quotion = divide(times, power);
    return quotion;
  }

  public double add(double a, double b) {
    double sum = a + b;
    return sum;
  }

  public double multiply(double a, double b) {
    double times = a * b;
    return times;
  }

  public double divide(double a, double b) {
    double quotion = a / b;
    return quotion;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
