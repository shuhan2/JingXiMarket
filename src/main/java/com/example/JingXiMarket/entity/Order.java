package com.example.JingXiMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.Timestamp;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long Id;
    private Long productId;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private String status;
    private String buyer;
//    private OrderTime time;
    private Date  createTime;
    private Date  payTime;
    private Date  cancelTime;
    private Date finishTime;
    private String address;
//    private Express express;

    public Order(Long id,Long productId, String productName,Long quantity, Long totalPrice, String status, String buyer,Date  createTime,Date  payTime,Date  cancelTime,Date  finishTime,String address) {
        this.Id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.buyer = buyer;
        this.createTime = createTime;
        this.payTime = payTime;
        this.cancelTime = cancelTime;
        this.finishTime = finishTime;
        this.address = address;
//        this.express = express;
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
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    public Date  getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date  createTime) {
        this.createTime = createTime;
    }

    public Date  getPayTime() {
        return payTime;
    }

    public void setPayTime(Date  payTime) {
        this.payTime = payTime;
    }

    public Date  getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date  cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date  getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date  finishTime) {
        this.finishTime = finishTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//    public Express getExpress() {
//        return express;
//    }
//
//    public void setExpress(Express express) {
//        this.express = express;
//    }



}
