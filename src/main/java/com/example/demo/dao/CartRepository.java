package com.example.demo.dao;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Products;
import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
    ArrayList<Cart> findAllByUser(Optional<User> user);
    void deleteByUserAndProducts(Optional<User> user, Optional<Products> products);
}
