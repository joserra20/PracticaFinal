package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.Fee;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.repository.FeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeeControllerE2ETest {

    @LocalServerPort
    private int port;


    private TestRestTemplate testRestTemplate = new TestRestTemplate("carlota@comillas.edu", "hola");

    @Autowired
    FeeRepository repository;

    @Test
    public void return_ok_when_getAll() {
        //given
        List<Fee> expextedResult = (List<Fee>) repository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/fees/allFees";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Fee>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Fee>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }



}