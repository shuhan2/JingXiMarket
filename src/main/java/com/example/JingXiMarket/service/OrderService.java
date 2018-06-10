package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.ExpressHalfway;
import com.example.JingXiMarket.entity.Order;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ExpressRepository expressRepository;
    int index = 0;

    public static long[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        long[] result = new long[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }
    long[] array = randomCommon(100000,999999,1000);
    //create
    public Order addOrder(@RequestBody Order order){

        return  orderRepository.save(order);
    }

    //find
    public Order checkOrderById(@RequestBody Long id){
        return  orderRepository.findById(id).get();
    }
    public List<Order> checkOrdersByName(@RequestBody String buyer){
        return orderRepository.findByBuyer(buyer);
    }
//pay order
    public String paidOrder(@RequestBody long id){
        Order order = orderRepository.findById(id).get();
        if(order!=null){
            order.setStatus("paid");
            orderRepository.save(order);
            Express express = new Express();
            express.setId(array[index++]);
            express.setProductId(order.getProductId());
            express.setProductName(order.getProductName());
            ExpressHalfway expressHalfway = new ExpressHalfway();
            Date date = new Date();
            expressHalfway.setTime(date);
            expressHalfway.setStatus("CREATE");
            expressHalfway.setAddress(order.getAddress());
            List<ExpressHalfway> expressHalfwayList = new ArrayList<ExpressHalfway>();
            expressHalfwayList.add(expressHalfway);
            express.setHalfway(expressHalfwayList);
            express.setQuantity(order.getQuantity());
            expressRepository.save(express);
            return "pay success";
        }
        throw   new NotFoundEx(id,"order");
    }
    //
    public  String undoOrder(@RequestBody long id){
        Order order  = orderRepository.findById(id).get();
        if (order!=null){
            order.setStatus("undo");
            orderRepository.save(order);
            return "undo success";
        }
        throw   new NotFoundEx(id,"order");

    }
    public  String finishOrder(@RequestBody long id){
        Order order  = orderRepository.findById(id).get();
        if (order!=null){
            order.setStatus("undo");
            orderRepository.save(order);
            return "finish success";
        }
        throw   new NotFoundEx(id,"order");
    }


}
