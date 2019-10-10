package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(path = "/cart")
    public ArrayList<Cart> getCart(){
        return cartService.getEmail(LoginController.principal);
    }

    @GetMapping(path = "/cart/addItem/productId/{id}")
    public String addItemToCart(@PathVariable("id") Long productId){
        return cartService.addItemToCart(LoginController.principal,productId);
    }

    @GetMapping(path = "/cart/deleteItem/productId/{id}")
    public String deleteItemFromCart(@PathVariable("id") Long id){
        return cartService.deleteItemFromCart(id,LoginController.principal);
    }

    @GetMapping(path = "/cart/increment/{value}/product/{productId}")
    public String increment(@PathVariable("value") int value,
                            @PathVariable("productId") Long productId){
        return cartService.increment(value,productId,LoginController.principal);
    }

    @GetMapping(path = "/cart/decrement/{value}/product/{productId}")
    public String decrement(@PathVariable("value") int value,
                            @PathVariable("productId") Long productId){
        return cartService.decrement(value,productId,LoginController.principal);
    }
}
