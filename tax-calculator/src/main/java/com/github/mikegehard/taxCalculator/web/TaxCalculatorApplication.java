package com.github.mikegehard.taxCalculator.web;

import com.github.mikegehard.taxCalculator.domain.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class TaxCalculatorApplication {
    private Log log = LogFactory.getLog(TaxCalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TaxCalculatorApplication.class, args);
    }

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/")
    public TaxCalculation home() {
        ServiceLocator locator = new ServiceLocator(loadBalancer);
        Optional<URL> propertyServiceLocation = locator.get("PROPERTY LOOKUP");

        Function<URL, Optional<TaxCalculation>> getZipCodeCalculation = (url) -> {
            log.debug("Getting tax calculation.");
            PropertyInformationRepository repo = new PropertyInformationRepository(url);
            Optional<PropertyInformation> info = repo.propertInformationFor(123.345, 123.456);
            return info.map(i -> new ZipCodeCalculation(i.getZipCode()));
        };

        return propertyServiceLocation.flatMap(getZipCodeCalculation).orElseGet(() -> {
            log.debug("Returning null calculation");
            return new NullCalculation();
        });
    }
}
