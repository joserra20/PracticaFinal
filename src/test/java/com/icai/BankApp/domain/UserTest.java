package com.icai.BankApp.domain;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {



    @Test
    void return_email_if_valid_pattern() {
        // Given
        User user = new User();

        //When
        user.setEmail("carlota@gmail.com");

        //Then
        Assertions.assertEquals(user.getEmail(),"carlota@gmail.com");

    }


}