package com.inventory.stockwise;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth") // Base path for all endpoints in this controller
public class LoginController {

    // In-memory storage of users (for demonstration purposes)
    private Map<String, String> users = new ConcurrentHashMap<>();

    // Handle OPTIONS request for CORS preflight
    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }

    // Login endpoint (using simple in-memory data)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();

        // Check if email exists in in-memory users map and if the passwords match
        if (users.containsKey(email) && users.get(email).equals(password)) {
            response.put("status", "success");
            response.put("message", "Login successful");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid email or password");
        }
        return response;
    }

    // Register endpoint (stores users in memory)
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();

        // Check if the email is already registered
        if (users.containsKey(email)) {
            response.put("status", "error");
            response.put("message", "Email already exists");
        } else {
            // Register the new user by storing the email and password
            users.put(email, password);
            response.put("status", "success");
            response.put("message", "Registration successful");
        }
        return response;
    }
}
