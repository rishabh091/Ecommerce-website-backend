package com.example.demo.dao;

import com.example.demo.domain.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {

    List<Products> findAllByCategory(String category);
    List<Products> findAllByPrice(double price);
}
