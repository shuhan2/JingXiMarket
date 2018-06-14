package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Orders;
//import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.exception.OrderCreateEx;
import com.example.JingXiMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderControl {
    @Autowired
    OrderService orderService;
    //find
    @GetMapping
    List<Orders> findOrderList(){
        return orderService.getOrderList();
    }
    @GetMapping(value = "{buyer}")
    List<Orders> findOrderListByBuyer(@PathVariable String buyer){
        return orderService.getOrderListByBuyer(buyer);
    }
    //create orders
    @PostMapping
    Orders createOrder(@RequestParam(value = "buyer", required =false)String buyer,@RequestParam(value = "productId", required =false)long productId,@RequestParam(value = "quantity", required =false)long quantity) throws OrderCreateEx {
        if (quantity < 0){
            throw new OrderCreateEx("quantity can't less than 0");
        }
        return orderService.createOrder(buyer,productId,quantity);
    }

    @PutMapping
    //pay order
    String paidOrder(@RequestParam(value = "Id", required =false) long id,@RequestParam(value = "status", required =false)String status){
        return orderService.updateOrderStatus(id,status);
    }

}

