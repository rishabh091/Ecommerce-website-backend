package com.example.demo.controller;

import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @PostMapping(path = "/checkUser", produces = "application/json")
    public String checkLogin(@RequestBody User user){
        System.out.println("Login service call");
        boolean permission=userRepositoryClass.checkUser(user);

        if(permission){
            System.out.println("Login Permission Granted");
            return "Access Granted.";
        }
        else{
            System.out.println("Login Permission Denied");
            return "Access Denied.";
        }
    }
}
