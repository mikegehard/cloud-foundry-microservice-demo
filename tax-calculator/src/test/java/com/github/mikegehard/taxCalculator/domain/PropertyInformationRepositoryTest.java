package com.github.mikegehard.taxCalculator.domain;

import com.github.mikegehard.taxCalculator.domain.PropertyInformation;
import com.github.mikegehard.taxCalculator.domain.PropertyInformationRepository;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class PropertyInformationRepositoryTest {

    private static final int PORT = 8089;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(PORT);

    @Test
    public void properlyParsesApiResponse() throws MalformedURLException {
        stubFor(get(urlEqualTo("/"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"zipCode\":\"80302\"}")));

        URL url = new URL(String.format("http://localhost:%d", PORT));

        PropertyInformationRepository repo = new PropertyInformationRepository(url);

        Optional<PropertyInformation> info = repo.propertInformationFor(1, 2);

        assert(info.isPresent());

        assertEquals(info.get().getZipCode(), "80302");
    }

}