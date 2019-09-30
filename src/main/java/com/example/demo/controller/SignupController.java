package com.example.demo.controller;

import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @PostMapping(path = "/sendingData" , produces="application/json")
    public String signUp(@RequestBody User user) {
        System.out.println("Sign up service is working");
        userRepositoryClass.add(user);

        return "Success";
    }
}
