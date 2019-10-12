package com.example.demo.dao;

import com.example.demo.domain.Products;
import com.example.demo.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ProductRepositoryClass {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderHistoryService orderHistoryService;

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
        return (ArrayList<Products>) productRepository.findAllByActive(true);
    }

    public Optional<Products> getFields(Long id){
        return productRepository.findById(id);
    }

    public ArrayList<Products> getByCategory(String category){
        return (ArrayList<Products>)productRepository.findAllByCategoryAndActive(category,true);
    }

    public ArrayList<Products> getByCategoryAndPrice(String category,double p1,double p2){
        return (ArrayList<Products>)productRepository.findAllByCategoryAndPriceBetweenAndActive(category,p1,p2,true);
    }

    public Optional<Products> getById(Long id){
        return productRepository.findById(id);
    }

    public String editProduct(Products product){
        System.out.println("Product id : "+product.getId());

        Long id=product.getId();
        Optional<Products> oldProduct=productRepository.findById(id);
        oldProduct.get().setActive(false);
        productRepository.save(oldProduct.get());

        product.setActive(true);
        product.setId(null);
        productRepository.save(product);

        return "\"Product edited\"";
    }
}
