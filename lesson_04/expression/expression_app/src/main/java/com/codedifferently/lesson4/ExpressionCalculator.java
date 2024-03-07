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
    double addAnswer = a + b;
    return addAnswer;
  }

  public double multiply(double addAnswer, double c) {
    double multiplyAnswer = addAnswer * c;
    return multiplyAnswer;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double divide(double multiplyAnswer, double d) {
    double divideAnswer = multiplyAnswer / d;
    return divideAnswer;
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
