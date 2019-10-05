package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.services.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserRepositoryClass {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserManagement userManagement;

    public void add(User user){
        System.out.println("Adding a value");
        userRepository.save(user);
    }

//    public boolean checkUser(User user){
//        System.out.println("Checking permissions of login request.");
//        boolean permission=false;
//        ArrayList<User> userList=(ArrayList<User>) userRepository.findAll();
//
//        permission=userManagement.checkLogin(user,userList);
//
//        return permission;
//    }
}
