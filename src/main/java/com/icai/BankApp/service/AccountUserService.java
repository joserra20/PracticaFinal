package com.icai.BankApp.service;

import com.icai.BankApp.domain.AccountUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountUserService {
    List<Long> getUserIdById(Long id);
    List<Long> getAccountIdById(Long id);
    AccountUser save(AccountUser ele);
}
