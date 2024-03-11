package com.codedifferently.lesson4;
 
public class ExpressionCalculator {
  /**
   * Returns the result of adding two numbers.
   *
   * @param a The first number
   * @param b The second number
   * @return The sum of a and b
   */
  public double add(double a, double b) {
    return a + b;
  }
 
  /**
   * Returns the result of dividing two numbers.
   *
   * @param a The dividend
   * @param b The divisor
   * @return The result of dividing a by b
   */
  public double divide(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Cannot divide by zero");
    }
    return a / b;
  }
 
  /**
   * Returns the result of multiplying two numbers.
   *
   * @param a The first number
   * @param b The second number
   * @return The product of a and b
   */
  public double multiply(double a, double b) {
    return a * b;
  }
 
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   *
   * @param a The first number
   * @param b The second number
   * @param c The third number
   * @param d The fourth number
   * @param e The exponent
   * @return The result of the expression ((a + b) * c) / d^e
   */
  public double calculate(double a, double b, double c, double d, double e) {
    double sum = add(a, b);
    double product = multiply(sum, c);
    double exponentiation = pow(d, e);
    return divide(product, exponentiation);
  }
 
  /**
   * Returns the result of raising a number to the power of another number.
   *
   * @param base The base number
   * @param exponent The exponent
   * @return The result of raising base to the power of exponent
   */
  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}