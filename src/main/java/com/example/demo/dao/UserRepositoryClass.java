package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryClass {
    @Autowired
    UserRepository userRepository;

    public void add(User user){
        System.out.println("Adding a value");
        userRepository.save(user);
    }
}
