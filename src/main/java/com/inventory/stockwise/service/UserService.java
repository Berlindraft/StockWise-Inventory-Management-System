package com.inventory.stockwise.service;

import com.inventory.stockwise.model.User;
import com.inventory.stockwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(User user) {
        // Check if the email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }

        // Save user to the database
        userRepository.save(user);
        return true;
    }
}
