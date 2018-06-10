package com.example.JingXiMarket.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class ExpressHalfway {
//    private Long expressId;
@Id
@GeneratedValue
    private String address;
    private Date time;
    private String status;

    public ExpressHalfway(String address, Date  time, String status) {
//        this.expressId = expressId;
        this.address = address;
        this.time = time;
        this.status = status;
    }
    public ExpressHalfway(){

    }
//    public Long getExpressId() {
//        return expressId;
//    }

//    public void setExpressId(Long expressId) {
//        this.expressId = expressId;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date  getTime() {
        return time;
    }

    public void setTime(Date  time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
