package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private int isActive;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "isSeller")
    private boolean isSeller;

    public User() {}

    public User(@JsonProperty("name") String name,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email,
                @JsonProperty("mobile") String mobile,
                @JsonProperty("address") String address,
                @JsonProperty("isSeller") boolean isSeller) {
        this.name=name;
        this.password=password;
        this.email=email;
        this.mobile=mobile;
        this.address=address;
        this.isSeller=isSeller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getActive() {
        return isActive;
    }

    public void setActive(int active) {
        this.isActive = active;
    }
}
