package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryClass {
    @Autowired
    UserRepository userRepository;

    public void add(User user){
        System.out.println("Adding a value");
        userRepository.save(user);
    }

    public Optional<User> getByEmail(String email){
        System.out.println("Getting by email");
        return userRepository.findByEmail(email);
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
}
