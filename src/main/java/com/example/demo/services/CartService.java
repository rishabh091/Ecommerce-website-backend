package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductRepositoryClass;
import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.Cart;
import com.example.demo.domain.Products;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepositoryClass productRepositoryClass;

    private ArrayList<Cart> getCartFromCurrentUser(Principal principal){
        Optional<User> user=userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Cart> cart=cartRepository.findAllByUser(user);

        return cart;
    }

    public ArrayList<Cart> getEmail(Principal principal){
        String email=principal.getName();
        Optional<User> user=userRepositoryClass.getByEmail(email);

        return cartRepository.findAllByUser(user);
    }

    public String addItemToCart(Principal principal,Long id){
        Optional<Products> product=productRepositoryClass.getById(id);
        Optional<User> user=userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Cart> cart=getCartFromCurrentUser(principal);

        for(int i=0;i<cart.size();i++){
            Cart cartObject=cart.get(i);

            if(cartObject.getProducts()==product.get()){
                cartObject.setQuantity(cartObject.getQuantity()+1);

                cartRepository.save(cartObject);
                return "\"Quantity increased\"";
            }
        }

        Cart cartObject=new Cart();
        cartObject.setQuantity(1);
        cartObject.setProducts(product.get());
        cartObject.setUser(user.get());

        cartRepository.save(cartObject);
        return "\"Item added to cart\"";
    }

    @Transactional
    public String deleteItemFromCart(Long productId,Principal principal){
        Optional<Products> product=productRepositoryClass.getById(productId);
        Optional<User> user=userRepositoryClass.getByEmail(principal.getName());

        cartRepository.deleteByUserAndProducts(user,product);

        return "\"deletion completed\"";
    }

    public String increment(int value,Long productId,Principal principal){
        ArrayList<Cart> cart=getCartFromCurrentUser(principal);
        Optional<Products> products=productRepositoryClass.getById(productId);

        for(int i=0;i<cart.size();i++){
            Cart cartObject=cart.get(i);

            if(cartObject.getProducts()==products.get()){
                cartObject.setQuantity(cartObject.getQuantity()+value);
                cartRepository.save(cartObject);

                return "\"successful\"";
            }
        }

        return "\"unsuccessful\"";
    }

    public String decrement(int value,Long productId,Principal principal){
        ArrayList<Cart> cart=getCartFromCurrentUser(principal);
        Optional<Products> products=productRepositoryClass.getById(productId);

        for(int i=0;i<cart.size();i++){
            Cart cartObject=cart.get(i);

            if(cartObject.getProducts()==products.get()){
                cartObject.setQuantity(cartObject.getQuantity()-value);
                cartRepository.save(cartObject);

                return "\"successful\"";
            }
        }

        return "\"unsuccessful\"";
    }
}
