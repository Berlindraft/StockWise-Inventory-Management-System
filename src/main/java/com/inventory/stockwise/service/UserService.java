package com.inventory.stockwise.service;

import com.inventory.stockwise.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User saveUser(User student);
    public List<User> getAllUser();
}