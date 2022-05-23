package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.repository.AccountRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerE2ETest {
    @LocalServerPort
    private int port;


    private TestRestTemplate testRestTemplate = new TestRestTemplate("carlota@comillas.edu", "hola");

    @Autowired
    AccountRepository repository;

    @Test
    public void return_ok_when_getAll() {
        //given
        List<Account> expextedResult = (List<Account>) repository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts/allAccounts";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Account>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }

    @Test
    void return_account_when_get_by_user() {
        //given
        List<Account> expextedResult = (List<Account>) repository.accByUser(1L);
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts/byUser/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Account>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());
    }

    @Test
    void return_account_when_get_by_id() {
        //given

        Account expextedResult = repository.findById(2L).get();
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts/getById/2";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<Account> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Account>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }

    @Test
    void return_ok_when_delete() {
        //given
        Optional<Account> expectedResult = repository.findById(1L);

        Boolean expextedResult = expectedResult.isPresent();
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts/delete/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<Boolean> result = testRestTemplate.exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Boolean>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }


    //happy path
    @Test
    void return_created_when_valid_POST() {
        //given
        Account account = new Account("ES21000000000000005",300,"STANDARD");
        Account expectedResult = repository.save(account);
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts/save";
        HttpHeaders headers = HttpHeaders.EMPTY;
        HttpEntity<Account> entity = new HttpEntity<>(account,headers);

        //when
        ResponseEntity<Account> result = testRestTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Account>(){} );

        //then
        Assertions.assertEquals(result.getBody(), expectedResult);
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

    }

}