package com.example.demo.services;

import com.example.demo.controller.LoginController;
import com.example.demo.dao.HistoryRepository;
import com.example.demo.dao.UserRepositoryClass;
import com.example.demo.domain.Cart;
import com.example.demo.domain.OrderHistory;
import com.example.demo.domain.Products;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderHistoryService {

    @Autowired
    CartService cartService;

    @Autowired
    UserRepositoryClass userRepositoryClass;

    @Autowired
    HistoryRepository historyRepository;

    public String addItemsToHistory(Principal principal){
        ArrayList<Cart> carts=cartService.getEmail(principal);
        Optional<User> user=userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Products> products=new ArrayList<>();

        for(int i=0;i<carts.size();i++){
            //add items to product list
            products.add(carts.get(i).getProducts());

            //delete cart from carts table
            cartService.deleteItemFromCart(carts.get(i));
        }

        //saving products in history
        int i=0;
        int j=0;
        while (i<products.size() && j<carts.size()){
            OrderHistory orderHistory=new OrderHistory();
            orderHistory.setUser(user.get());
            orderHistory.setProducts(products.get(i));
            orderHistory.setQuantity(carts.get(j).getQuantity());
            historyRepository.save(orderHistory);

            i++;
            j++;
        }

        return "\"Item bought successfully\"";
    }

    public ArrayList<OrderHistory> getHistory(Principal principal){
        Optional<User> user=userRepositoryClass.getByEmail(principal.getName());

        System.out.println("Getting history from carts");
        return historyRepository.findByUser(user);
    }
}
