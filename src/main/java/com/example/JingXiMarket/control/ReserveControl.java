package com.example.JingXiMarket.control;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reserve")
public class ReserveControl {
    @Autowired
    ReserveRepository reserveRepository;
    //add
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
   Reserve saveReserve(@RequestBody Reserve reserve){
        reserve.setQuantity((long)0);
        return  reserveRepository.save(reserve);
    }
    //update
    @PutMapping("{id}")
    Reserve putReserve(@PathVariable long id, @RequestBody Reserve reserve) throws NotFoundException{
        Reserve mreserver = reserveRepository.findById(id).get();
        if (mreserver == null){
            throw   new NotFoundEx(id,"reserve");
        }
        reserve.setProductId(id);
        return reserveRepository.save(reserve);
    }

}
