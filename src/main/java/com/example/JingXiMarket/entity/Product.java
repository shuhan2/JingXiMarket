package com.example.JingXiMarket.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id;



    private String productName;
    private String description;
    private Long singlePrice;
    private Long quantity;
    public Product(){

    }
    public Product(Long id,String productName, String description, Long singlePrice, Long quantity) {
        this.id = id;
        this.productName = productName;

        this.description = description;
        this.singlePrice = singlePrice;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Long singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }



}
