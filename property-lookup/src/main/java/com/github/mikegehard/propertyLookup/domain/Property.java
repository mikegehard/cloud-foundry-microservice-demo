package com.github.mikegehard.propertyLookup.domain;

import java.util.Random;

public class Property {
    final private Random random = new Random();

    public String getZipCode() {
        if (random.nextInt() % 2 == 0)
            return "80302";
        else
            return "90401";
    }
}
