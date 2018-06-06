package com.example.JingXiMarket.entity;

import java.util.Date;

public class OrderTime {
    private Date createTime;
    private Date payTime;



    private Date cancelTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }
    public OrderTime(){

    }
    public OrderTime(Date createTime, Date payTime, Date cancelTime) {
        this.createTime = createTime;
        this.payTime = payTime;
        this.cancelTime = cancelTime;
    }


}
