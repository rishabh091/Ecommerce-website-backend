package com.example.demo.controller;

import com.example.demo.dao.ProductRepositoryClass;
import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
}
