package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.AccountUser;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.repository.AccountUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountUserControllerE2ETest {
    @LocalServerPort
    private int port;


    private TestRestTemplate testRestTemplate = new TestRestTemplate("carlota@comillas.edu", "hola");

    @Autowired
    AccountUserRepository repository;


    @Test
    void return_created_when_valid_POST() {
        //given
        AccountUser account = new AccountUser(3L,2L);
        AccountUser expectedResult = repository.save(account);
        String url = "http://localhost:" + Integer.toString(port) + "/api/accounts_and_users/save";
        HttpHeaders headers = HttpHeaders.EMPTY;
        HttpEntity<AccountUser> entity = new HttpEntity<>(account,headers);

        //when
        ResponseEntity<AccountUser> result = testRestTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<AccountUser>(){} );

        //then
        Assertions.assertEquals(result.getBody(), expectedResult);
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

    }

}