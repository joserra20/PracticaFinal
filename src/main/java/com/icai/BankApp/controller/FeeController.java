package com.icai.BankApp.controller;

import com.icai.BankApp.domain.Fee;
import com.icai.BankApp.service.AccountService;
import com.icai.BankApp.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {
    @Autowired
    FeeService feeService;

    @GetMapping("/allFees")
    public ResponseEntity<Iterable<Fee>> getAllFees(){
        return ResponseEntity.ok().body(feeService.getAll());
    }
}
