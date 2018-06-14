package com.example.JingXiMarket.service;

import com.example.JingXiMarket.entity.*;
import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.expr.Expr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping
    public Express findExpressById(@PathVariable long id){
        return expressRepository.findById(id).get();
    }
    //create
    public Express createExpress(@PathVariable Express express){
        return expressRepository.save(express);
    }
    //send
    public String updateExpressStatus(@PathVariable Long id, @PathVariable String status){
        Express express = expressRepository.findById(id).get();
        if (express!=null){
            if (status.equals("send")){

                ExpressHalfway expressHalfway = new ExpressHalfway();
                expressHalfway.setStatus("SEND");
                Date  time = new Date();
                expressHalfway.setTime(time);
                //??
                String address = "ChangS";
                expressHalfway.setAddress(address);
                List<ExpressHalfway> list = new ArrayList<>();
                list.add(expressHalfway);
                express.setHalfway(list);
                expressRepository.save(express);
                return "Send Success";
            }
            else if(status.equals("sign")){
                express.setStatus("sign");
                //库存
//                Reserve reserve = reserveRepository.findByProductId(express.getProductId());
//                reserve.setQuantity(reserve.getQuantity()-express.getQuantity());
//                reserveRepository.save(reserve);
//                //货物库存
//                Product product = productRepository.findById(id).get();
//                product.setQuantity(reserve.getQuantity());
//                productRepository.save(product);
                //订单
                Long expressId = express.getOrderId();
                Orders order = orderRepository.findByExpressId(expressId);
                order.setStatus("FINISH");
//            order.setExpress(express);
                orderRepository.save(order);
                expressRepository.save(express);
                return "Sign Success";
            }
            else{
                return "fail";
            }
        }
        throw  new NotFoundEx(id,"express");
    }

//check


    //update
    public Express updateExpress(@PathVariable long id, ExpressHalfway transport){
        Express express = expressRepository.findById(id).get();
        if (express != null) {
            express.getHalfway().add(transport);
            express.setHalfway(express.getHalfway());
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
}
