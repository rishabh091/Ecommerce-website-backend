package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.services.SameEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
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

    public String editUser(User user, Principal principal){
        try{
            Optional<User> previousUser=getByEmail(principal.getName());
            user.setId(previousUser.get().getId());
            user.setActive(1);

            System.out.println(user);
            userRepository.save(user);
            return "\"Changes saved\"";
        }
        catch (Exception e){
            System.out.println(e);
            return "\"Unable to save changes\"";
        }
    }

    public boolean checkUser(User user) throws SameEmailException {
        ArrayList<User> userList=(ArrayList<User>) userRepository.findAll();

        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getEmail().equals(user.getEmail())){
                throw new SameEmailException();
            }
        }
        return true;
    }
}
