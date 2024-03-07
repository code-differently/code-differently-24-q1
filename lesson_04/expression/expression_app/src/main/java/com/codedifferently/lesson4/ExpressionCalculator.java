package com.codedifferently.lesson4;

public class ExpressionCalculator {
  /**
   * Returns the calculation of ((a + b) * c) / d^e
   */

  public double add(double a, double b){
    double addSum = a + b;
    return addSum;

   }

  public double multiply(double a, double b){
    double product = a * b;
    return product;

  }


  public double divide(double a, double b){
    double quotient = a / b;
    return quotient;

  }




  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  public double calculate(double a, double b, double c, double d, double e) {
    double sum = add(a, b);
    double productSum = multiply(a, b);
    double power = pow(b, e);

    double result = divide(productSum,power);
    // Implement your code here to return the correct value.
    return result;
  }
}
