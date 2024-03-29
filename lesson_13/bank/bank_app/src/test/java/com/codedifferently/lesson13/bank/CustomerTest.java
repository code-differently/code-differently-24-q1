package com.codedifferently.lesson13.bank;

import org.junit.jupiter.api.Test;

import com.codedifferently.lesson13.bank.BusinessCheckingAccount;

public class CustomerTest {

    @Test
    void testCustomserHasBusinessAccount() {
Customer customer = new Customer();
BusinessCheckingAccount businessCheckingAccount = new BusinessCheckingAccount(123fe32);
customer.addAccount(businessCheckingAccount);
boolean has BusinessCheckingAccount = customer.getIsBusiness();

assertTrue (hasBusinessAccount);
    }

    
}
