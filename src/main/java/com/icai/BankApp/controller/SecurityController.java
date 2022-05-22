package com.icai.BankApp.controller;

import com.icai.BankApp.domain.User;
import com.icai.BankApp.repository.UserRepository;
import com.icai.BankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class SecurityController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        User usuario = userService.getUserByEmail(principal.getName());
        return usuario.getFirstName() + " " + usuario.getLastName();
    }

    @RequestMapping(value = "/currentId", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserId(Principal principal) {
        User usuario = userService.getUserByEmail(principal.getName());
        return usuario.getId().toString();
    }
}
