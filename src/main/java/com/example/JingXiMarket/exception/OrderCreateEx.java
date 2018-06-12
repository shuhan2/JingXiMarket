package com.example.JingXiMarket.exception;

public class OrderCreateEx extends RuntimeException {
    public OrderCreateEx(String info) {
        super("Order created faliled:"+info);

    }
}