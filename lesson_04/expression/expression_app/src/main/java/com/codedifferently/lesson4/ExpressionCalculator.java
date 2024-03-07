package com.codedifferently.lesson4;

public class ExpressionCalculator {

  public double calculate(double a, double b, double c, double d, double e) {
    // Step 1: Add a and b together
    double sum = add(a, b);

    // Step 2: Multiply the result by c
    double product = multiply(sum, c);

    // Step 3: Raise d to the power of e
    double power = pow(d, e);

    // Step 4: Divide the result of the multiplication by the result of the exponentiation
    double result = divide(product, power);

    return result;
  }

  public double add(double a, double b) {
    return a + b;
  }

  /** Multiplies two numbers together. */
  public double multiply(double a, double b) {
    return a * b;
  }

  /** Divides two numbers. */
  public double divide(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero!");
    }
    return a / b;
  }

  /**
   * Calculates the result of raising a base to a given exponent.
   *
   * @param base the base number
   * @param exponent the exponent
   * @return the result of raising the base to the exponent
   */
  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
