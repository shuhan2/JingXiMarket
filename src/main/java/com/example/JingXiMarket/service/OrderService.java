package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Order;
import com.example.JingXiMarket.reposity.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order addOrder(@RequestBody Order order){

        return  orderRepository.save(order);
    }

    //o
    public Order checkOrderById(@RequestBody Long id){
        return  orderRepository.findById(id).get();
    }
    public List<Order> checkOrdersByName(@RequestBody String buyer){
        return orderRepository.findByBuyer(buyer);
    }
//
    public String paidOrder(@RequestBody long id){
        Order order = orderRepository.findById(id).get();
        if(order!=null){
            order.setStatus("paid");
            orderRepository.save(order);
            return "pay success";
        }
        throw   new NotFoundEx(id,"order");
    }
    public  String undoOrder(@RequestBody long id){
        Order order  = orderRepository.findById(id).get();
        if (order!=null){
            order.setStatus("undo");
            orderRepository.save(order);
            return "undo success";
        }
        throw   new NotFoundEx(id,"order");

    }
    public  String finishOrder(@RequestBody long id){
        Order order  = orderRepository.findById(id).get();
        if (order!=null){
            order.setStatus("undo");
            orderRepository.save(order);
            return "finish success";
        }
        throw   new NotFoundEx(id,"order");
    }


}
