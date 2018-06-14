package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.service.ExpressService;
import com.example.JingXiMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/express")
public class ExpressControl {
    @Autowired
    ExpressService expressService;
    @Autowired
    OrderService orderService;
    //create
    @GetMapping
    List<Express> findAll(){
        return expressService.getAllExpress();
    }

    @GetMapping(value = "{id}")
    Express findExpressById(@PathVariable Long id)
    {
        return expressService.findExpressById(id);
    }

    //sign
    @PutMapping
    String updateExpressStatus(@RequestParam(value = "id", required =false) Long id,@RequestParam(value = "status", required =false)String status){
        return expressService.updateExpressStatus(id,status);
    }



}
