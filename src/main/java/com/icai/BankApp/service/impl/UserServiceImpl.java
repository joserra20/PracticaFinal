package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.User;
import com.icai.BankApp.repository.UserRepository;
import com.icai.BankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(obj -> new User(
                        obj.getFirstName(),
                        obj.getLastName(),
                        obj.getPassword(),
                        obj.getEmail(),
                        obj.getUserType())).toList();
    }
}
