package com.codedifferently.lesson4;

public class ExpressionCalculator {

  public double calculate(double a, double b, double c, double d, double e) {
    double result = divide(multiply(add(a, b), c), pow(d, e)); 
    return result;
  }

  public double add(double a, double b) {
    return a + b; // sum of a+b
  }

  public double divide(double a, double b) {
    if (b == 0) {
    }
    return a / b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent); //gives base to the power of exponent 
  }
}
