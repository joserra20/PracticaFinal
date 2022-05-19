package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import com.icai.BankApp.repository.AccountRepository;
import com.icai.BankApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .map(obj -> new Account(
                        obj.getIBAN(),
                        obj.getBalance(),
                        obj.getUserType())).toList();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteAccount(Account account) {
    accountRepository.delete(account);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByIban(String iban) {
        return accountRepository.getAccountByIban(iban);
    }
}
