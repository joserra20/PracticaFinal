package com.icai.BankApp.service;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.AccountUser;
import com.icai.BankApp.domain.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface TransactionService {
    List<Transaction> getTransactionByAccount(Long id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionByDate(LocalDate date);
    Transaction save(Transaction transaction);
    void deleteTransaction(Transaction transaction);

    Optional<Transaction> getTransactionId(Long id);
}
