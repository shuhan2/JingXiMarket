package com.example.JingXiMarket.entity;

import java.util.Date;

public class ExpressHalfway {
    private Long expressId;
    private String address;
    private Date time;
    private String status;

    public ExpressHalfway(Long expressId, String address, Date time, String status) {
        this.expressId = expressId;
        this.address = address;
        this.time = time;
        this.status = status;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
