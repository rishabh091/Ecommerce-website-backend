package com.example.demo.dao;

import com.example.demo.domain.OrderHistory;
import com.example.demo.domain.Products;
import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface HistoryRepository extends CrudRepository<OrderHistory, Long> {
    ArrayList<OrderHistory> findByUser(Optional<User> user);
    void deleteByProducts(Optional<Products> products);
}
