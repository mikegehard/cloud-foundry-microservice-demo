package com.github.mikegehard.taxCalculator.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyInformation {
    private final String zipCode;

    @JsonCreator
    public PropertyInformation(@JsonProperty("zipCode") String zipCode){
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}
