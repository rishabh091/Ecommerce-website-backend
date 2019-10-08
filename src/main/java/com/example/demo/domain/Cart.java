//package com.example.demo.domain;
//
//import javax.persistence.*;
//
//@Entity
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long cartId;
//
//    private int quantity;
//
//    private double finalPrice;
//
//    @OneToMany
//    Products products;
//
//    public Long getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(Long cartId) {
//        this.cartId = cartId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getFinalPrice() {
//        return finalPrice;
//    }
//
//    public void setFinalPrice(double finalPrice) {
//        this.finalPrice = finalPrice;
//    }
//
//    public Products getProducts() {
//        return products;
//    }
//
//    public void setProducts(Products products) {
//        this.products = products;
//    }
//}
