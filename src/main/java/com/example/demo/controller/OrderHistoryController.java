package com.example.demo.controller;

import com.example.demo.domain.OrderHistory;
import com.example.demo.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping()
public class OrderHistoryController {

    @Autowired
    OrderHistoryService orderHistoryService;

    @GetMapping(path = "/order/createOrder")
    public String buyProduct(){
        return orderHistoryService.addItemsToHistory(LoginController.principal);
    }

    @GetMapping(path = "/order/orderHistory")
    public ArrayList<OrderHistory> orderHistory(){
        return orderHistoryService.getHistory(LoginController.principal);
    }
}
