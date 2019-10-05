package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping(path = "/checkUser", produces = "application/json")
    public String checkLogin(){
        return "\"login successful\"";
    }
}
