package com.icai.BankApp.service;

import com.icai.BankApp.domain.AccountUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountUserService {
    List<AccountUser> getUserIdById(float id);
    List<Long> getAccountIdById(float id);

    AccountUser save(AccountUser ele);
}
