package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   *
   * @param a
   * @param b
   * @return
   */

  /* add a+b
   * multiply a+b by c
   * figure out exponent
   * divide product
   */

  public double add(double a, double b) {
    double sum = a + b;
    return sum;
  }

  public double multiply(double sum, double c) {
    double product = sum * c;
    return product;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double divide(double product, double pow) {
    double quotient = product / pow;
    return quotient;
  }

  public double calculate(double a, double b, double c, double d, double e) {
    // Implement your code here to return the correct value.
    double addition = add(a, b);
    double multiplication = multiply(addition, c);
    double power = pow(d, e);
    double division = divide(multiplication, power);
    return division;
  }

  /* public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }*/
}
