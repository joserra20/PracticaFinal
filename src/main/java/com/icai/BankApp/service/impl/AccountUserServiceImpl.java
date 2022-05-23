package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.AccountUser;
import com.icai.BankApp.repository.AccountUserRepository;
import com.icai.BankApp.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserServiceImpl implements AccountUserService {
    @Autowired
    AccountUserRepository accountUserRepository;

    @Override
    public List<Long> getUserIdById(Long id) {
        return accountUserRepository.getUserIdById(id);
    }

    @Override
    public List<Long> getAccountIdById(Long id) {
        return accountUserRepository.getAccountIdById(id);
    }

    @Override
    public AccountUser save(AccountUser ele) {
        return accountUserRepository.save(ele);
    }
}
