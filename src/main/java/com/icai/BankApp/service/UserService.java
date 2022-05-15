package com.icai.BankApp.service;

import com.icai.BankApp.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
}
