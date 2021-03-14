package com.example.illustris.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserService userService;

    @Autowired
    public UserService(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return null;
    }

    public void addNewUser(User user) {
    }

    public void deleteUser(Long userId) {
    }
    
}
