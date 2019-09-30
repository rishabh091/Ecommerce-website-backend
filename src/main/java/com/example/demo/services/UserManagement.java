package com.example.demo.services;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserManagement {

    public boolean checkLogin(User user, ArrayList<User> userList){
        boolean result=false;

        String inputEmail=user.getEmail();
        String inputPassword=user.getPassword();

        boolean checkUser=false;
        boolean checkPassword=false;

        for(int i=0;i<userList.size();i++){
            User userObject=userList.get(i);

            if(userObject.getEmail().equals(inputEmail) && userObject.getPassword().equals(inputPassword)){
                checkUser=true;
                checkPassword=true;
                break;
            }
        }

        if(checkUser && checkPassword){
            result=true;
        }

        return result;
    }
}
