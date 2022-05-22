package com.icai.BankApp.service.impl;

import com.icai.BankApp.domain.User;
import com.icai.BankApp.repository.UserRepository;
import com.icai.BankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(obj -> new User(
                        obj.getId(),
                        obj.getDni(),
                        obj.getFirstName(),
                        obj.getLastName(),
                        obj.getPassword(),
                        obj.getEmail(),
                        obj.getUserType())).toList();
    }

    @Override
    public List<User> getUsersByAccount(Long accId) {
        return userRepository.usersByAcc(accId);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }
    @Override
    public User getUserByName(String name, String surname){
        return userRepository.getUserByName(name, surname);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);

        return newUser;
    }
}
