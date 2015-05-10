package com.github.mikegehard.taxCalculator.domain;

public class NullCalculation implements TaxCalculation {
    public long getValue() {
        return 0;
    }
}
