package com.github.mikegehard.propertyLookup.web;

import com.github.mikegehard.propertyLookup.domain.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class PropertyLookupApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyLookupApplication.class, args);
    }

    @RequestMapping("/")
    public Property home(){
        return new Property();
    }
}
