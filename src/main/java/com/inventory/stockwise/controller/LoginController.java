package com.inventory.stockwise.controller;

import com.inventory.stockwise.model.User;
import com.inventory.stockwise.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth") // Base path for all endpoints in this controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService; // Inject the UserService to handle registration and login

    // Handle OPTIONS request for CORS preflight
    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }


    // Register endpoint
    @PostMapping("/register")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<User> list(){
        return userService.getAllUser();
    }
}
