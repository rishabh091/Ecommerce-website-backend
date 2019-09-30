package com.example.demo.dao;

import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductRepositoryClass {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(Products products){
        System.out.println("Adding a product");
        productRepository.save(products);
        System.out.println("Product Added");
    }

    public ArrayList<Products> getAllProducts(){
        return (ArrayList<Products>) productRepository.findAll();
    }
}
