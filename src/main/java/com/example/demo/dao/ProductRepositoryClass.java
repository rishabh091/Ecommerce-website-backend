package com.example.demo.dao;

import com.example.demo.domain.Products;
import com.example.demo.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public Set<Products> getItemsFromSearch(String value){
        ArrayList<Products> products=(ArrayList<Products>) productRepository.findAll();
        Set<Products> result=new HashSet<>();

        for(int i=0;i<products.size();i++){
            if(products.get(i).getName().toLowerCase().contains(value.toLowerCase()) ||
                    products.get(i).getBrand().toLowerCase().contains(value.toLowerCase()) ||
                    products.get(i).getCategory().toLowerCase().contains(value.toLowerCase()) ||
                    products.get(i).getDetails().toLowerCase().contains(value.toLowerCase()) ||
                    products.get(i).getModel().toLowerCase().contains(value.toLowerCase())){

                result.add(products.get(i));
            }
        }

        System.out.println("Search result : "+result);
        return result;
    }

    public Set<Products> filterOnSearch(String value,double price1, double price2){
        Set<Products> products=getItemsFromSearch(value);
        Set<Products> result=new HashSet<>();

        Iterator<Products> iterator=products.iterator();

        while (iterator.hasNext()){
            Products currentProduct=iterator.next();
            if(currentProduct.getPrice()>=price1 && currentProduct.getPrice()<=price2){
                result.add(currentProduct);
            }
        }
        return result;
    }
}
