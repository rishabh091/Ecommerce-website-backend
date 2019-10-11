package com.example.demo.dao;

import com.example.demo.domain.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {

    List<Products> findAllByCategory(String category);
    List<Products> findAllByPriceBetween(double startPrice,double endPrice);
    List<Products> findAllByCategoryAndPriceBetween(String category,double startPrice,double endPrice);
}
