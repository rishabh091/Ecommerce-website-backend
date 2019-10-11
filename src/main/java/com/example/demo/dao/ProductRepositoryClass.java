package com.example.demo.dao;

import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ProductRepositoryClass {

    @Autowired
    ProductRepository productRepository;

    public boolean addProduct(Products products){
        try{
            System.out.println("Adding a product");
            productRepository.save(products);
            System.out.println("Product Added");

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public ArrayList<Products> getAllProducts(){
        return (ArrayList<Products>) productRepository.findAll();
    }

    public Optional<Products> getFields(Long id){
        return productRepository.findById(id);
    }

    public ArrayList<Products> getByCategory(String category){
        return (ArrayList<Products>)productRepository.findAllByCategory(category);
    }

    public ArrayList<Products> getByCategoryAndPrice(String category,double p1,double p2){
        return (ArrayList<Products>)productRepository.findAllByCategoryAndPriceBetween(category,p1,p2);
    }

    public Optional<Products> getById(Long id){
        return productRepository.findById(id);
    }

    public String editProduct(Products product){
        productRepository.deleteById(product.getId());
        productRepository.save(product);

        return "\"Product edited\"";
    }
}
