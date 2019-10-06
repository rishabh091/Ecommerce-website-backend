package com.example.demo.controller;

import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @PostMapping(path = "/sendingData" , consumes="application/json")
    public String signUp(@RequestBody User user) {
        user.setActive(1);
        System.out.println("Sign up service is working");
        userRepositoryClass.add(user);

        return "\"Success\"";
    }
}
