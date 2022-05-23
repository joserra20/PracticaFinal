package com.icai.BankApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icai.BankApp.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void return_unathorized_when_post_without_header(){

        //Given
        User user = new User("00111222C","Juan","Gutierrez","hola","juancomillas.edu","STANDARD");


        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users/save")
                    .contentType(APPLICATION_JSON_VALUE)
                    .content(asJsonString(user)))
                    .andDo(print())
                    .andExpect(status().isUnauthorized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}