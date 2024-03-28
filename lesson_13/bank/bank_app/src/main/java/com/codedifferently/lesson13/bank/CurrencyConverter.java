package com.codedifferently.lesson13.bank;

/** Interface for currency converters. */
public interface CurrencyConverter {
  double convert(double amount, CurrencyType fromCurrency, CurrencyType toCurrency);
}
