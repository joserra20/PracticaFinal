package com.icai.BankApp.service;

import com.icai.BankApp.domain.Account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long id);
    void deleteAccount(Account account);
    Account save(Account account);

    Account getAccountByIban(String iban);
}
