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
    @PostMapping()
    Orders createOrder(@PathVariable("buyer")String buyer,@PathVariable("productId")long productId,@PathVariable("quantity")long quantity) throws OrderCreateEx {
        if (quantity < 0){
            throw new OrderCreateEx("quantity can't less than 0");
        }
        return orderService.createOrder(buyer,productId,quantity);
    }

    @PutMapping(value = "{id}/paid")
    //pay order
    String paidOrder(@PathVariable long id){
        return orderService.paidOrder(id);
    }
    //finish order
    @PutMapping(value = "{id}/finish")
    String finishOrder(@PathVariable long id){
        return orderService.finishOrder(id);
    }
    @PutMapping(value = "{id}/undo")
    String undoOrder(@PathVariable long id){
        return orderService.undoOrder(id);
    }
}

