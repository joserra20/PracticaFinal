package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerE2ETest {
    @LocalServerPort
    private int port;


    private TestRestTemplate testRestTemplate = new TestRestTemplate("carlota@comillas.edu", "hola");

    @Autowired
    UserRepository repository;


    @Test
    public void return_ok_when_getAll() {
        //given
        List<User> expextedResult = (List<User>) repository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/allUsers";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<User>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<User>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }

    @Test
    void return_account_when_get_by_account() {
        //given
        List<User> expextedResult = (List<User>) repository.usersByAcc(1L);
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/byAccount/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<User>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<User>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());
    }

    @Test
    void return_user_when_get_by_id() {
        //given
        User expextedResult = repository.findById(1L).get();
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/getById/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<User> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<User>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }
    @Test
    void return_ok_when_delete() {
        //given
        Optional<User> expectedResult = repository.findById(1L);

        Boolean expextedResult = expectedResult.isPresent();
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/delete/1";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<Boolean> result = testRestTemplate.exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Boolean>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }
    @Test
    void return_created_when_valid_POST() {
        //given
        User user = new User("00111222C","Juan","Gutierrez","hola","juan@comillas.edu","STANDARD");
        User expectedResult = repository.save(user);
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/save";
        HttpHeaders headers = HttpHeaders.EMPTY;
        HttpEntity<User> entity = new HttpEntity<>(user,headers);

        //when
        ResponseEntity<User> result = testRestTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<User>(){} );

        //then
        Assertions.assertEquals(result.getBody().getFirstName(), expectedResult.getFirstName());
        Assertions.assertEquals(result.getBody().getEmail(), expectedResult.getEmail());
        Assertions.assertEquals(result.getBody().getDni(), expectedResult.getDni());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

    }
    @Test
    void return_user_when_get_by_email() {
        //given
        User expextedResult = repository.findByEmail("carlota@comillas.edu");
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/getByEmail/carlota@comillas.edu";
        HttpHeaders headers = HttpHeaders.EMPTY;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<User> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<User>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }


}