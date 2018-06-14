package com.example.JingXiMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Reserve {
    @Id
    @GeneratedValue


    private Long id;



    private Long productId;
    private String productName;
    private Long quantity;
    public Reserve(){

    }
    public Reserve(Long id,Long productId,String productName, Long quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }



}
