package com.leonelcujcuj.ahorcado.controller;


import com.leonelcujcuj.ahorcado.model.User;
import com.leonelcujcuj.ahorcado.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.exc.InvalidFormatException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserByid(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @ExceptionHandler({IllegalArgumentException.class, InvalidFormatException.class})
    public ResponseEntity<Map<String, String>> handleExceptions(Exception ex) {
        Map<String, String> error = new HashMap<>();
        if (ex instanceof InvalidFormatException) {
            error.put("error", "La fecha de registro no tiene un formato válido");
        } else {
            error.put("error", ex.getMessage());
        }
        return ResponseEntity.badRequest().body(error);
    }
}
