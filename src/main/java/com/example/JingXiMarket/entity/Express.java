package com.example.JingXiMarket.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Express {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long productId;
    private String productName;
    private Long quantity;
    @Transient
    private List<ExpressHalfway> halfway;
    private String status;
//    private Date time;
    private String buyer;
    private String courier;
//    @OneToOne
//    @JoinColumn(name = "id")
//    private Orders order;

    public Express(Long id,Long productId, String productName,Long quantity, List<ExpressHalfway> halfway, String status, String buyer,String courier) {
        this.Id =id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.halfway = halfway;
        this.status = status;

        this.buyer = buyer;
        this.courier = courier;
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

    public List<ExpressHalfway> getHalfway() {
        return halfway;
    }

    public void setHalfway(List<ExpressHalfway> halfway) {
        this.halfway = halfway;
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

//    public Orders getOrder() {
//        return order;
//    }
//
//    public void setOrder(Orders order) {
//        this.order = order;
//    }
    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
    public Express(){

    }




}
