package com.icai.BankApp.controller;


import ch.qos.logback.classic.Logger;
import com.icai.BankApp.domain.Account;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.service.AccountService;
import com.icai.BankApp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    @Autowired
    AccountService accountService;

    @GetMapping("/allAccounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok().body(accountService.getAllAccounts()) ;

    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<Account>> getAccByUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok().body(accountService.getAccByUserId(userId)) ;

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(accountService.getAccountById(id).get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAccountById(@PathVariable("id") Long id) {
        Optional<Account> account = accountService.getAccountById(id);
        if (account.isPresent()){
            accountService.deleteAccount(account.get());
        }
        return ResponseEntity.ok().body(account.isPresent());

    }

    @PostMapping( "/save")
    public ResponseEntity<Account> saveUser( @RequestBody Account account) {

        Account a = accountService.save(account);
        return ResponseEntity
                .created(URI.create(String.format("/user/%s",account.getIBAN()))).body(a);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Account> getAccountByIban(@RequestBody String  iban){
        return ResponseEntity.ok().body(accountService.getAccountByIban(iban));
    }
}
