package com.example.demo_database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_database.Request.UserCreationRequest;
import com.example.demo_database.Request.UserUpdateRequest;
import com.example.demo_database.entity.User;
import com.example.demo_database.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        if (userRepository.existsByusername(request.getUsername()))
            throw new RuntimeException("user existed");
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User getUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    // xoa user
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(String userId, UserUpdateRequest request) {

        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}
