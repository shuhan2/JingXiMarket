package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.service.ReserveService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reserve")
public class ReserveControl {
    @Autowired
    ReserveService reserveService;
    //find
    @GetMapping
    List<Reserve> findAllReserve(){
        return reserveService.getReserveList();
    }
    //add
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
   Reserve saveReserve(@RequestBody Reserve reserve){

        return  reserveService.saveReserve(reserve);
    }
    //update
    @PutMapping("{id}")
    Reserve putReserve(@PathVariable long id, @RequestBody Reserve reserve) throws NotFoundException{

        return reserveService.putReserve(id,reserve);
    }

}
