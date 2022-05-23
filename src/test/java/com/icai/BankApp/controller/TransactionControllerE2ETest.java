package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.Transaction;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionControllerE2ETest {
    @LocalServerPort
    private int port;


    private TestRestTemplate testRestTemplate = new TestRestTemplate("carlota@comillas.edu", "hola");

    @Autowired
    TransactionRepository repository;

    @Test
    public void return_ok_when_getAll() {
        //given
        List<Transaction> expextedResult = (List<Transaction>) repository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/transactions/getAll";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Transaction>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transaction>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }

    @Test
    void return_ok_when_get_by_acc() {
        //given
        List<Transaction> expextedResult = (List<Transaction>) repository.getTransactionByAccount(1L);
        String url = "http://localhost:" + Integer.toString(port) + "/api/transactions/getByAccount/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Transaction>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transaction>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());
    }

    @Test
    void return_ok_when_get_by_date() {
        //given
        List<Transaction> expextedResult = (List<Transaction>) repository.getTransactionByDate(LocalDate.parse("2022-01-05"));
        String url = "http://localhost:" + Integer.toString(port) + "/api/transactions/getByDate/2022-01-05";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<Transaction>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transaction>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());
    }

    @Test
    void return_ok_when_delete() {
        //given
        Optional<Transaction> expectedResult = repository.findById(1L);

        Boolean expextedResult = expectedResult.isPresent();
        String url = "http://localhost:" + Integer.toString(port) + "/api/transactions/delete/1";
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
        Transaction transaction = new Transaction(1L,2L,300,LocalDate.parse("2022-01-06"));
        Transaction expectedResult = repository.save(transaction);
        String url = "http://localhost:" + Integer.toString(port) + "/api/transactions/save";
        HttpHeaders headers = HttpHeaders.EMPTY;
        HttpEntity<Transaction> entity = new HttpEntity<>(transaction,headers);

        //when
        ResponseEntity<Transaction> result = testRestTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Transaction>(){} );

        //then
        Assertions.assertEquals(result.getBody(), expectedResult);
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

    }
}