package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/express")
public class ExpressControl {
    @Autowired
    ExpressService expressService;
    //create
    @GetMapping
    List<Express> findAll(){
        return expressService.getAllExpress();
    }

    @GetMapping(value = "{id}")
    Express findExpressById(@PathVariable long id)
    {
        return expressService.findExpressById(id);
    }



}
