package com.icai.BankApp.service;

import com.icai.BankApp.domain.Fee;
import org.springframework.stereotype.Service;

@Service
public interface FeeService {
    Iterable<Fee> getAll();
}
