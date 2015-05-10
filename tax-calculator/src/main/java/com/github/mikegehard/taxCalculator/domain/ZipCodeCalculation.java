package com.github.mikegehard.taxCalculator.domain;

public class ZipCodeCalculation implements TaxCalculation {
    private String zipCode;

    public ZipCodeCalculation(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getValue() {
        if (zipCode.startsWith("8"))
            return 10000;
        else
            return 15000;
    }
}
