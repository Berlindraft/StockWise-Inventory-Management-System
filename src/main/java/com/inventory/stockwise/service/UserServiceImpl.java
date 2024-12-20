package com.inventory.stockwise.service;

import com.inventory.stockwise.model.User;
import com.inventory.stockwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User saveUser(User student) {
        return userRepository.save(student);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}