package com.example.demo.dao;

import com.example.demo.domain.Products;
import com.example.demo.services.ProductManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductRepositoryClass {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductManagement productManagement;

    public void addProduct(Products products){
        System.out.println("Adding a product");
        productRepository.save(products);
        System.out.println("Product Added");
    }

    public ArrayList<Products> getAllProducts(){
        return (ArrayList<Products>) productRepository.findAll();
    }

    public Long getId(String name){
        ArrayList<Products> productList= (ArrayList<Products>) productRepository.findAll();

        Long id=productManagement.getId(productList,name);
        return id;
    }
}
