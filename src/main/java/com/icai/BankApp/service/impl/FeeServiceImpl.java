package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.Fee;
import com.icai.BankApp.repository.FeeRepository;
import com.icai.BankApp.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    FeeRepository feeRepository;

    @Override
    public Iterable<Fee> getAll() {
        return feeRepository.findAll();
    }
}
