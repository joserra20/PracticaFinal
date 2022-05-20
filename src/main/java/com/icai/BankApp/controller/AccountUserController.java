package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.AccountUser;
import com.icai.BankApp.domain.User;
import com.icai.BankApp.service.AccountService;
import com.icai.BankApp.service.AccountUserService;
import com.icai.BankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/accounts_and_users")
public class AccountUserController {
    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @Autowired
    AccountUserService accountUserService;



    @GetMapping("/UsersByAccount/{id}")
    public ResponseEntity<List<User>> getAllUsers(@PathVariable("id") Long id){
        List<AccountUser> users = accountUserService.getUserIdById(id);
        List<User> result = null;
        for (AccountUser u: users){
            result.add(userService.getUserById(u.getU_id()).get());
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/AccountsByUser/{id}")
    public ResponseEntity<List<Account>> getAllAccounts(@PathVariable("id") Long id){
        List<Long> users = accountUserService.getAccountIdById(id);
        List<Account> result = null;
        for (Long u: users){
            result.add(accountService.getAccountById(u).get());
        }
        return ResponseEntity.ok().body(result);
    }

    @PostMapping( "/save")
    public ResponseEntity<AccountUser> saveUser( @RequestBody AccountUser ele) {
        AccountUser ele1 = accountUserService.save(ele);
        return ResponseEntity
                .created(URI.create(String.format("/user/%s",ele.getU_id()))).body(ele1);
    }
}