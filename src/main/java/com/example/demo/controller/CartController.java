package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping()
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(path = "/cart")
    public ArrayList<Cart> getCart(Principal principal){
        return cartService.getEmail(principal);
    }

    @GetMapping(path = "/cart/addItem/productId/{id}")
    public String addItemToCart(@PathVariable("id") Long productId,
                                Principal principal){
        return cartService.addItemToCart(principal,productId);
    }

    @GetMapping(path = "/cart/deleteItem/productId/{id}")
    public String deleteItemFromCart(@PathVariable("id") Long id,
                                     Principal principal){
        return cartService.deleteItemFromCart(id,principal);
    }
}
