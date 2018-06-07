package com.example.JingXiMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Express {
    @Id
    @GeneratedValue
    private Long Id;
    private Long productId;
    private Long quantity;
    private List<ExpressHalfway> halfway;
    private String status;
    private Date time;
    private String buyer;
    private String courier;

    public Express(Long id,Long productId, Long quantity, List<ExpressHalfway> halfway, String status, Date time,String buyer,String courier) {
        this.Id =id;
        this.productId = productId;
        this.quantity = quantity;
        this.halfway = halfway;
        this.status = status;
        this.time = time;
        this.buyer = buyer;
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

    public List<ExpressHalfway> getAddress() {
        return halfway;
    }

    public void setAddress(List<ExpressHalfway> halfway) {
        this.halfway = halfway;
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
        return buyer;
    }

    public void setBuyers(String buyer) {
        this.buyer = buyer;
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
