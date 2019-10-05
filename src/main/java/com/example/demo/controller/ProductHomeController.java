package com.example.demo.controller;

import com.example.demo.dao.ProductRepositoryClass;
import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping()
public class ProductHomeController {

    @Autowired
    ProductRepositoryClass productRepositoryClass;

    @PostMapping(path = "/addProduct", produces = "application/json")
    public String addProduct(@RequestBody Products products){
        System.out.println("Adding products");
        productRepositoryClass.addProduct(products);

        return "Product Inserted";
    }

    @GetMapping(path = "/home")
    public ArrayList<Products> getAllProducts(){
        return productRepositoryClass.getAllProducts();
    }

    @GetMapping(path = "/home/id/{id}")
    public Optional<Products> getFields(@PathVariable("id") Long id){
        System.out.println("Sending id.");
        return productRepositoryClass.getFields(id);
    }

    @GetMapping(path = "/home/priceFilter/{price}/{price2}")
    public ArrayList<Products> getByPrice(@PathVariable("price") double price,
                                          @PathVariable("price2") double price2){
        System.out.println("Getting by price.");
        return productRepositoryClass.getByPrice(price,price2);
    }

    @GetMapping(path = "/home/category/{category}")
    public ArrayList<Products> getByCategory(@PathVariable("category") String category){
        System.out.println("Getting by category.");
        return productRepositoryClass.getByCategory(category);
    }
}
