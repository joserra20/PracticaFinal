package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.Transaction;
import com.icai.BankApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Transaction>> getAllAccounts(){
        return ResponseEntity.ok().body(transactionService.getAllTransactions()) ;

    }

    @GetMapping("/getByAccount/{id}")
    public ResponseEntity<List<Transaction>> getAccByUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok().body(transactionService.getTransactionByAccount(userId)) ;

    }

    @GetMapping("/getByDate/{date}")
    public ResponseEntity<List<Transaction>> getAccountByDate(@PathVariable("date") String date){
        return ResponseEntity.ok().body(transactionService.getTransactionByDate(LocalDate.parse(date)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAccountById(@PathVariable("id") Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionId(id);
        if (transaction!=null){
            transactionService.deleteTransaction(transaction.get());
        }
        return ResponseEntity.ok().body(transaction.isPresent());

    }

    @PostMapping( "/save")
    public ResponseEntity<Transaction> saveUser( @RequestBody Transaction transaction) {

        Transaction t = transactionService.save(transaction);
        return ResponseEntity
                .created(URI.create(String.format("/user/%s",transaction.getId().toString()))).body(t);
    }
}
