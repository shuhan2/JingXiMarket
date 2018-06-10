package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Order;
//import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderControl {
    @Autowired
    OrderService orderService;
    //create order
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Order addOrder(@RequestBody Order order){

        return  orderService.addOrder(order);
    }
    @PutMapping(value = "{id}/paid")
    //pay order
    String paidOrder(@RequestBody long id){
        return orderService.paidOrder(id);
    }
    //finish order
    @PutMapping(value = "{id}/finish")
    String finishOrder(@RequestBody long id){
        return orderService.finishOrder(id);
    }
    @PutMapping(value = "{id}/undo")
    String undoOrder(@RequestBody long id){
        return orderService.undoOrder(id);
    }
}

