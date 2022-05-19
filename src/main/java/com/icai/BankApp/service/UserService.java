package com.icai.BankApp.service;

import com.icai.BankApp.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void deleteUser(User u);
    User save(User u);

    User getUserByName(String name, String surname);

}
