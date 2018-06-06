package com.example.JingXiMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Express {
    @Id
    @GeneratedValue
    private Long Id;
    private Long productId;
    private Long quantity;
    private String address;
    private String status;
    private Date time;
    private String buyers;



    private String courier;

    public Express(Long id,Long productId, Long quantity, String address, String status, Date time) {
        this.Id =id;
        this.productId = productId;
        this.quantity = quantity;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public String getBuyers() {
        return buyers;
    }

    public void setBuyers(String buyers) {
        this.buyers = buyers;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
    public Express(){

    }




}
