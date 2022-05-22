package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.Transaction;
import com.icai.BankApp.repository.TransactionRepository;
import com.icai.BankApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionByAccount(Long id) {
        return transactionRepository.getTransactionByAccount(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return StreamSupport.stream(transactionRepository.findAll().spliterator(), false)
                .map(obj -> new Transaction(
                        obj.getId(),
                        obj.getOriginAcc(),
                        obj.getDestinationAcc(),
                        obj.getAmount(),
                        obj.getDate())).toList();
    }

    @Override
    public List<Transaction> getTransactionByDate(LocalDate date) {
        return transactionRepository.getTransactionByDate(date);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
    transactionRepository.delete(transaction);
    }
    @Override
    public Optional<Transaction> getTransactionId(Long id){
        return transactionRepository.findById(id);
    }
}
