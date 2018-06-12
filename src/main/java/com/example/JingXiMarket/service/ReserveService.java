package com.example.JingXiMarket.service;

import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service("resrveService")
public class ReserveService {
    @Autowired
    ReserveRepository reserveRepository;
    //find
    @GetMapping
    public List<Reserve> getReserveList(){
        return reserveRepository.findAll();
    }
    //add
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Reserve saveReserve(@RequestBody Reserve reserve){

        return  reserveRepository.save(reserve);
    }
    //update
    @PutMapping("{id}")
    public Reserve putReserve(@PathVariable long id, @RequestBody Reserve reserve) throws NotFoundException {
        Reserve mreserver = reserveRepository.findById(id).get();
        if (mreserver == null){
            throw   new NotFoundEx(id,"reserve");
        }
        reserve.setProductId(id);
        return reserveRepository.save(reserve);
    }

}
