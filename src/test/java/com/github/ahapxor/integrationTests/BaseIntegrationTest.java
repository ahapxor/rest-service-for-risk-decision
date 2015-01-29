package com.github.ahapxor.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jfairy.producer.person.Person;

import java.io.IOException;

public abstract class BaseIntegrationTest extends BaseTestCase {
    final ObjectMapper objectMapper = new ObjectMapper();
    final String decisionMakeApiUrl = "http://localhost:8080/decisions";

    CloseableHttpClient client;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        client = HttpClientBuilder.create().build();
    }

    protected DecisionDto callDecisionMakeApi(PurchaseDto purchase)
            throws IOException, ApiErrorException {

        HttpPost request = new HttpPost(decisionMakeApiUrl);
        request.setHeader("Content-Type", "application/json");

        String purchaseJson = objectMapper.writeValueAsString(purchase);
        request.setEntity(new ByteArrayEntity(purchaseJson.getBytes("UTF8")));

        HttpResponse response = client.execute(request);

        if(response.getStatusLine().getStatusCode() >= 400) {
            throw new ApiErrorException();
        }

        String decisionJson = EntityUtils.toString(response.getEntity());

        return objectMapper.readValue(decisionJson, DecisionDto.class);
    }

    protected static PurchaseDto createPurchase(){
        Person person = getPerson();
        return createPurchase(person.email(), person.firstName(), person.lastName(), producer.randomBetween(100, 500));
    }

    protected static PurchaseDto createPurchase(int amount){
        Person person = getPerson();
        return createPurchase(person.email(), person.firstName(), person.lastName(), amount);
    }

    protected static PurchaseDto createPurchase(String email, int amount){
        Person person = getPerson();
        return createPurchase(email, person.firstName(), person.lastName(), amount);
    }

    protected static PurchaseDto createPurchase(String email, String firstName, String lastName, int amount){
        return new PurchaseDto(email, firstName, lastName, amount);
    }

    class ApiErrorException extends Exception {}
}
