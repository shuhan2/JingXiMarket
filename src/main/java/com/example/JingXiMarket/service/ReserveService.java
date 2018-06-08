package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReserveService {
    @Autowired
    ReserveRepository reserveRepository;
    //add
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Reserve saveReserve(@RequestBody Reserve reserve){

        return  reserveRepository.save(reserve);
    }
    //update
    @PutMapping("{id}")
    Reserve putReserve(@PathVariable long id, @RequestBody Reserve reserve) throws NotFoundException {
        Reserve mreserver = reserveRepository.findById(id).get();
        if (mreserver == null){
            throw   new NotFoundEx(id,"reserve");
        }
        reserve.setProductId(id);
        return reserveRepository.save(reserve);
    }

}
