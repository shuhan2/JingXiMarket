package com.example.JingXiMarket.Enum;

import com.example.JingXiMarket.entity.Order;

import java.util.HashMap;
import java.util.Map;

public enum orderEnum {
    CTRATE(1,"create"),
    PAID(2,"paid"),
    UNDO(3,"undo"),
    FINISH(4,"finish"),
    INVALID(5,"invalid");
    public static final Map<String, orderEnum> map = new HashMap<>();
    public static  orderEnum mapping(String order){
        if (map.containsKey(order)){
            return map.get(order);
        }
        return orderEnum.INVALID;
    }
    private int orderStatusId;
    private String orderStatus;
    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    orderEnum(int orderStatusId,String orderStatus){
        this.orderStatusId = orderStatusId;
        this.orderStatus = orderStatus;
    }
}
