package com.codedifferently.lesson13.bank;

import java.util.UUID;

public class BusinessCustomer extends Customer {
    // Additional fields specific to business customers
    private String companyName;
    private String taxId;

    // Constructor
    public BusinessCustomer(String name, UUID id) {
        super(name, id);
        this.companyName = companyName;
        this.taxId = taxId;
    }

    // Getters and setters for additional fields
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    // Additional methods specific to business customers can be added here
}
