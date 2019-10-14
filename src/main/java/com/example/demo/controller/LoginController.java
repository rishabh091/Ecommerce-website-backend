package com.example.demo.controller;

import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepositoryClass userRepositoryClass;

    public static Principal principal;

    @GetMapping(path = "/checkUser", produces = "application/json")
    public String checkLogin(Principal principal){
        System.out.println("Logging in user.."+principal.getName());
        this.principal=principal;
        return "\"login successful\"";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logout servlet : "+authentication);

        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            request.getSession().invalidate();

            System.out.println("Logout successful");
            return "\"logout successful\"";
        }

        System.out.println("Logout Unsuccessful");
        return "\"logout unsuccessful\"";
    }

    @GetMapping(path = "/userInfo")
    public Optional<User> getUserByEmail(){
        return userRepositoryClass.getByEmail(principal.getName());
    }

    @PostMapping(path = "/editProfile")
    public String editProfile(@RequestBody User user){
        System.out.println("Editing profile");
        return userRepositoryClass.editUser(user,principal);
    }

}