package com.codedifferently.examples.lesson10.bad_ecommerce;

public class PaymentMethod {
    PaymentType paymentType;

    public PaymentMethod(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getType() {
        return this.paymentType;
    }
}

