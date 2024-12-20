package com.inventory.stockwise.controller;

import com.inventory.stockwise.model.User;
import com.inventory.stockwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth") // Base path for all endpoints in this controller
public class LoginController {

    @Autowired
    private UserService userService; // Inject the UserService to handle registration and login

    // Handle OPTIONS request for CORS preflight
    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }

    // Login endpoint
//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
//        String email = credentials.get("email");
//        String password = credentials.get("password");
//
//        Map<String, String> response = new HashMap<>();
//
//        try {
//            boolean isAuthenticated = userService.authenticateUser(email, password);
//            if (isAuthenticated) {
//                response.put("status", "success");
//                response.put("message", "Login successful");
//            } else {
//                response.put("status", "error");
//                response.put("message", "Invalid email or password");
//            }
//        } catch (Exception e) {
//            response.put("status", "error");
//            response.put("message", "An error occurred: " + e.getMessage());
//        }
//
//        return response;
//    }

    // Register endpoint
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        try {
            boolean isRegistered = userService.registerUser(user); // Delegate registration logic to service
            if (isRegistered) {
                response.put("status", "success");
                response.put("message", "Registration successful");
            } else {
                response.put("status", "error");
                response.put("message", "Email already exists");
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An error occurred: " + e.getMessage());
        }

        return response;
    }
}
