package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.ExpressHalfway;
import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Timestamp;
import java.security.cert.CertPath;
import java.util.Date;
import java.util.List;

@Service("expressService")
public class ExpressService {
    @Autowired
    ExpressRepository expressRepository;
    ReserveRepository reserveRepository;
    ProductRepository productRepository;
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
    @GetMapping()
    public Express checkExpress(@RequestBody long id){
       return expressRepository.findById(id).get();
    }
    //Sign
    public Express signExpress(@RequestBody long id) {
        Express express = expressRepository.findById(id).get();
        if (express != null) {
            express.setStatus("sign");
            Reserve reserve = reserveRepository.findById(id).get();
            reserve.setQuantity(reserve.getQuantity()-express.getQuantity());
            reserveRepository.save(reserve);
            Product product = productRepository.findById(id).get();
            product.setQuantity(reserve.getQuantity());
            productRepository.save(product);
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
