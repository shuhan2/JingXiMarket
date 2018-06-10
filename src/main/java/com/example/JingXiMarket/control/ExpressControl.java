package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/express")
public class ExpressControl {
    @Autowired
    ExpressService expressService;
    //create



}
