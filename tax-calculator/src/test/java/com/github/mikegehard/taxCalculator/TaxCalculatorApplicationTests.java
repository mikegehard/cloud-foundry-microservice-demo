package com.github.mikegehard.taxCalculator;

import com.github.mikegehard.taxCalculator.web.TaxCalculatorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TaxCalculatorApplication.class)
@WebAppConfiguration
@TestPropertySource(properties = { "eureka.client.enabled = false" })
public class TaxCalculatorApplicationTests {

	@Test
	public void contextLoads() {
	}

}
