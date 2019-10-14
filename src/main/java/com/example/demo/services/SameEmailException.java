package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class SameEmailException extends Exception{

    public SameEmailException(){
        super("Email is already in use.");
    }
}
