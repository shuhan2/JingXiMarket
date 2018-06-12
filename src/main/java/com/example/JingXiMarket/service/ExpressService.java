package com.example.JingXiMarket.service;

import com.example.JingXiMarket.entity.*;
import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service("expressService")
public class ExpressService {
    @Autowired
    ExpressRepository expressRepository;
    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    //getAll
    @GetMapping
    public List<Express> getAllExpress(){
        return expressRepository.findAll();
    }
    @GetMapping()
    public Express findExpressById(@RequestBody long id){
        return expressRepository.findById(id).get();
    }
    //send
    @PostMapping()
    public Express sendProduct(@RequestBody Long id){
        Express express = expressRepository.findById(id).get();
        if (express!=null){
            ExpressHalfway expressHalfway = new ExpressHalfway();
            expressHalfway.setStatus("SEND");
            Date  time = new Date();
            expressHalfway.setTime(time);
            expressHalfway.setAddress(express.getHalfway().get(0).getAddress());
            express.setHalfway(express.getHalfway());
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
//check

    //Sign
    public Express signExpress(@RequestBody long id) {
        Express express = expressRepository.findById(id).get();
        if (express != null) {
            express.setStatus("sign");
            //库存
            Reserve reserve = reserveRepository.findByProductId(express.getProductId());
            reserve.setQuantity(reserve.getQuantity()-express.getQuantity());
            reserveRepository.save(reserve);
            //货物库存
            Product product = productRepository.findById(id).get();
            product.setQuantity(reserve.getQuantity());
            productRepository.save(product);
            //订单
            Orders order = orderRepository.findByProductId(express.getProductId());
            order.setStatus("FINISH");
            order.setExpress(express);
            orderRepository.save(order);
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
    //update
    public Express updateExpress(@RequestBody long id, ExpressHalfway transport){
        Express express = expressRepository.findById(id).get();
        if (express != null) {
            express.getHalfway().add(transport);
            express.setHalfway(express.getHalfway());
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
}
