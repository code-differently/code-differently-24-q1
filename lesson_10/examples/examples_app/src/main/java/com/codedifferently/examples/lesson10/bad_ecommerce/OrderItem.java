package com.codedifferently.examples.lesson10.bad_ecommerce;

public class OrderItem {
  public String sku;
  public double price;
  public int quantity;
  public String name;

  public OrderItem(String sku, String name, double price, int quantity) {
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}
