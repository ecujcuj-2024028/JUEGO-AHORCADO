package com.leonelcujcuj.ahorcado.service;

import com.leonelcujcuj.ahorcado.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    List<User> getAllUsers();
    User getUserByid(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
