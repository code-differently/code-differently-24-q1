package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   *
   * @param a
   * @param b
   * @return
   */
  public double add(double a, double b) {
    double addSum = a + b;
    return addSum;
  }

  public double multiply(double addSum, double c) {
    double multiplySum = addSum * c;
    return multiplySum;
  }

  public double divide(double multiplySum, double d) {
    double divideSum = multiplySum / d;
    return divideSum;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double calculate(double a, double b, double c, double d, double e) {
    // Implement your code here to return the correct value.
    double sum = add(a, b);

    double product = multiply(sum, c);

    double power = pow(d, e);

    double result = divide(product, power);

    return result;
  }
}
