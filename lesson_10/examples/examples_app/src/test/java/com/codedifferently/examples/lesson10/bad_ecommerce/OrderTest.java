package com.codedifferently.examples.lesson10.bad_ecommerce;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

  private Order order;
  private Customer customer;

  @BeforeEach
  void setUp() {
    customer = mock(Customer.class);
    order = new Order(customer);
  }

  @Test
  void testAddItem() {
    OrderItem item = new OrderItem("SKU123", "Item 1", 10.0, 2);
    order.addItem(item);
    assertThat(order.getItems()).contains(item);
  }

  @Test
  void testRemoveItem() {
    OrderItem item1 = new OrderItem("SKU123", "Item 1", 10.0, 2);
    OrderItem item2 = new OrderItem("SKU456", "Item 2", 5.0, 3);
    order.addItem(item1);
    order.addItem(item2);
    order.removeItem("SKU123");
    assertThat(order.getItems()).doesNotContain(item1);
    assertThat(order.getItems()).contains(item2);
  }

  @Test
  void testCalculateTotal() {
    OrderItem item1 = new OrderItem("SKU123", "Item 1", 10.0, 2);
    OrderItem item2 = new OrderItem("SKU456", "Item 2", 5.0, 3);
    order.addItem(item1);
    order.addItem(item2);
    double expectedTotal = item1.price * item1.quantity + item2.price * item2.quantity;
    assertThat(order.calculateTotal()).isEqualTo(expectedTotal);
  }

  @Test
  void testGenerateInvoice() {
    OrderItem item1 = new OrderItem("SKU123", "Item 1", 10.0, 2);
    OrderItem item2 = new OrderItem("SKU456", "Item 2", 5.0, 3);
    order.addItem(item1);
    order.addItem(item2);
    String expectedInvoice =
        "Item,Qty,Amount\n" + "Item 1,2,10.0,20.0\n" + "Item 2,3,5.0,15.0\n" + ",,35.0";
    assertThat(order.generateInvoice()).isEqualTo(expectedInvoice);
  }

  @Test
  void testProcessPayment() {
    PaymentMethod creditCard = new PaymentMethod(PaymentType.CREDIT_CARD);
    PaymentMethod paypal = new PaymentMethod(PaymentType.PAYPAL);
    PaymentMethod bankTransfer = new PaymentMethod(PaymentType.BANK_TRANSFER);
    PaymentMethod unknown = new PaymentMethod(PaymentType.UNKNOWN);

    assertThat(order.processPayment(creditCard)).isTrue();
    assertThat(order.processPayment(paypal)).isTrue();
    assertThat(order.processPayment(bankTransfer)).isTrue();
    assertThat(order.processPayment(unknown)).isFalse();
  }
}
