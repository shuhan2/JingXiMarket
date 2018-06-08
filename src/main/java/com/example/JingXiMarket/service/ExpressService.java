package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.ExpressHalfway;
import com.example.JingXiMarket.reposity.ExpressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("expressService")
public class ExpressService {
    @Autowired
    ExpressRepository expressRepository;

    //create
    @PostMapping()
    public Express createExpress(@RequestBody Express express){
        return expressRepository.save(express);
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
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
    //update
    public Express updateExpress(@RequestBody long id, ExpressHalfway transport){
        Express express = expressRepository.findById(id).get();
        if (express != null) {
            express.getAddress().add(transport);
            express.setAddress(express.getAddress());
            return expressRepository.save(express);
        }
        throw  new NotFoundEx(id,"express");
    }
}
