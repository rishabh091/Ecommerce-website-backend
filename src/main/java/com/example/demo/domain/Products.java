package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productsTable")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;

    @Column(name = "productName")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "productDetails")
    private String details;

    @Column(name = "productModel")
    private String model;

    @Column(name = "productImage")
    private String imgUrl;

    @Column(name = "productCatergory")
    private String category;

    @NotNull
    @Column(columnDefinition = "boolean default false")
    private boolean inStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Products() {
    }

    public Products(String name, double price, String details, String imgUrl, String category, @NotNull boolean inStock,String model) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.imgUrl = imgUrl;
        this.category = category;
        this.inStock = inStock;
        this.model=model;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", category='" + category + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
