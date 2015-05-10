package com.github.mikegehard.taxCalculator.web;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class ServiceLocator {

    private LoadBalancerClient loadBalancer;

    public ServiceLocator(LoadBalancerClient loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public Optional<URL> get(String serviceName) {
        ServiceInstance instance = loadBalancer.choose(serviceName);

        if (instance == null) {
            return Optional.empty();
        }

        try {
            URL url = new URL(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
            return Optional.of(url);
        } catch (MalformedURLException e) {
            return Optional.empty();
        }
    }
}
