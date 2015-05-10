package com.github.mikegehard.propertyLookup;

import com.github.mikegehard.propertyLookup.web.PropertyLookupApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PropertyLookupApplication.class)
@WebAppConfiguration
@TestPropertySource(properties = { "eureka.client.enabled = false" })
public class PropertyLookupApplicationTests {

	@Test
	public void contextLoads() {
	}

}
