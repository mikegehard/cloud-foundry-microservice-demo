package com.github.mikegehard.taxCalculator.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public class PropertyInformationRepository {
    private final URL location;
    ObjectMapper mapper = new ObjectMapper();

    public PropertyInformationRepository(URL location) {
        this.location = location;
    }

    public Optional<PropertyInformation> propertInformationFor(double lat, double lng) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        ResponseHandler<String> responseHandler = response -> EntityUtils.toString(response.getEntity());

        try {
            HttpGet httpget = new HttpGet(location.toURI());
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println(String.format("Response: %s", responseBody));
            PropertyInformation value = mapper.readValue(responseBody, PropertyInformation.class);
            return Optional.of(value);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
