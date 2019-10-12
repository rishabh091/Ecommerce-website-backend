package com.example.demo.controller;

import com.example.demo.dao.ProductRepositoryClass;
import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ProductHomeController {

    @Autowired
    ProductRepositoryClass productRepositoryClass;

    @PostMapping(path = "/addProduct", produces = "application/json")
    public String addProduct(@RequestBody Products products){
        System.out.println("Adding products");
        products.setActive(true);
        boolean result=productRepositoryClass.addProduct(products);

        if(result)
            return "\"Product Inserted\"";
        else
            return "\"Server Error Try again later\"";
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

    @GetMapping(path = "/home/category/{category}")
    public ArrayList<Products> getByCategory(@PathVariable("category") String category){
        System.out.println("Getting by category.");
        return productRepositoryClass.getByCategory(category);
    }

    @GetMapping(path = "/home/category/{category}/priceFilter/{price1}/{price2}")
    public ArrayList<Products> getByCategoryAndPriceBetween(@PathVariable("category") String category,
                                                            @PathVariable("price1") double price1,
                                                            @PathVariable("price2") double price2){
        System.out.println("Getting by category and price");
        return productRepositoryClass.getByCategoryAndPrice(category,price1,price2);
    }

    @PostMapping(path = "/editProduct")
    public String editProduct(@RequestBody Products products){
        System.out.println(products.getId());
        return productRepositoryClass.editProduct(products);
    }
}
