package com.codedifferently.examples.lesson10.bad_ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {

  private List<OrderItem> items = new ArrayList<OrderItem>();
  private EmailService emailService = new EmailService();
  private Customer customer;

  public Order(Customer customer) {
    this.customer = customer;
  }

  public void addItem(OrderItem item) {
    items.add(item);
  }

  public void removeItem(String sku) {
    items.removeIf(i -> i.sku == sku);
  }

  public List<OrderItem> getItems() {
    return this.items;
  }

  public double calculateTotal() {
    double total = 0;
    for (OrderItem item : items) {
      total += item.price * item.quantity;
    }
    return total;
  }

  public String generateInvoice() {
    var sb = new StringBuilder();
    sb.append("Item,Qty,Amount\n");
    for (OrderItem item : items) {
      var total = item.price * item.quantity;
      sb.append(String.format("%s,%s,%s,%s\n", item.name, item.quantity, item.price, total));
    }
    sb.append(String.format(",,%s", calculateTotal()));
    return sb.toString();
  }

  public void emailReceiptToCustomer() {
    this.emailService.send(this.customer.getEmail(), "Customer invoice", this.generateInvoice());
  }

  public boolean processPayment(PaymentMethod method) {
    var result = false;
    switch (method.getType()) {
      case CREDIT_CARD:
        result = true;
        break;
      case PAYPAL:
        result = true;
        break;
      case BANK_TRANSFER:
        result = true;
        break;
      default:
        result = false;
    }
    return result;
  }
}
