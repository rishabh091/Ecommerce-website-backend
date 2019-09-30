package com.example.demo.services;

import com.example.demo.domain.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductManagement {

    public Long getId(ArrayList<Products> productList,String name){
        Long id = null;

        for(int i=0;i<productList.size();i++){
            Products products=productList.get(i);

            if(products.getName().equals(name)){
                id=products.getId();
                break;
            }
        }

        return id;
    }
}
