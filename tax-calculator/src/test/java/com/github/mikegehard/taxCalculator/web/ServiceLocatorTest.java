package com.github.mikegehard.taxCalculator.web;

import com.github.mikegehard.taxCalculator.web.ServiceLocator;
import org.junit.Test;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceLocatorTest {
    @Test
    public void returnsEmptyOptionWhenThereAreNoServicesToBeFound() {
        String serviceName = "Some Service";

        LoadBalancerClient client = mock(LoadBalancerClient.class);
        when(client.choose(serviceName)).thenReturn(null);

        ServiceLocator locator = new ServiceLocator(client);

        assertFalse(locator.get(serviceName).isPresent());
    }
}