package com.example.DynamoDBExample.controllers;

import com.example.DynamoDBExample.DynamoDbExampleApplication;
import com.example.DynamoDBExample.controllers.ApplicationController;
import com.example.DynamoDBExample.data.ObjectRequest;
import com.example.DynamoDBExample.data.ObjectResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@SpringBootTest(classes = DynamoDbExampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerTestIT {

    @LocalServerPort
    private int port;

    private ApplicationController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnNoContent() {
        ObjectRequest object = ObjectRequest.builder()
                .nome("Vinicius")
                .sobrenome("Nunes")
                .salarioMensal(new BigDecimal("10000.00"))
                .build();

        final ResponseEntity<ObjectResponse> response = this.restTemplate.postForEntity("http://localhost:" + port + "/saveObject", object, ObjectResponse.class);
    }
}
