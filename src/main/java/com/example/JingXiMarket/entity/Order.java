package com.example.JingXiMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long Id;
    private Long productId;
    private Long quantity;
    private Long totalPrice;
    private String status;
    private OrderTime time;

    public Order(Long id,Long productId, Long quantity, Long totalPrice, String status, OrderTime time) {
        this.Id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.time = time;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderTime getTime() {
        return time;
    }

    public void setTime(OrderTime time) {
        this.time = time;
    }




}
