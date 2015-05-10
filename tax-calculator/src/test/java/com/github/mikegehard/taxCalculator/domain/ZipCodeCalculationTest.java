package com.github.mikegehard.taxCalculator.domain;


import com.github.mikegehard.taxCalculator.domain.ZipCodeCalculation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZipCodeCalculationTest {

    @Test
    public void boulderAddressReturns10000() {
        ZipCodeCalculation calc = new ZipCodeCalculation("80302");

        assertEquals(calc.getValue(), 10000);
    }

    @Test
    public void santaMonicaAddressReturns15000() {
        ZipCodeCalculation calc = new ZipCodeCalculation("90401");

        assertEquals(calc.getValue(), 15000);
    }
}
