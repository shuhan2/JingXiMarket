package com.example.JingXiMarket.service;

import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.ExpressHalfway;
import com.example.JingXiMarket.entity.Orders;
import com.example.JingXiMarket.exception.OrderCreateEx;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.reposity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ExpressRepository expressRepository;
    @Autowired
    ProductRepository productRepository;

    int index = 10;
    int indexe = 0;

     public  List<Orders> getOrderList(){
        return orderRepository.findAll();
    }

    public  List<Orders> getOrderListByBuyer(String buyer){
        return orderRepository.findByBuyer(buyer);
    }
    //
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
    public Orders createOrder(@PathVariable("buyer")String buyer, @PathVariable("productId")long productId, @PathVariable("quantity")long quantity)  {
        Orders order = new Orders();
        if (productRepository.findById(productId).get()!=null) {
            if (quantity > productRepository.findById(productId).get().getQuantity()){
                throw   new OrderCreateEx("quantity can't more than product's reserve");
            }
            Date time = new Date();
            order.setCreateTime(time);
            order.setId((long) ++index);
            order.setProductId(productId);

            order.setProductName(productRepository.findById(productId).get().getName());
            order.setBuyer(buyer);
            order.setQuantity(quantity);
            order.setAddress("Wuh");
            order.setStatus("CREATED");
            order.setTotalPrice(productRepository.findById(productId).get().getSinglePrice() * quantity);

            return orderRepository.save(order);
        }
     throw   new NotFoundEx(productId,"product");

    }

    //find
    public Orders checkOrderById(@RequestBody Long id){
        return  orderRepository.findById(id).get();
    }
    public List<Orders> checkOrdersByName(@RequestBody String buyer){
        return orderRepository.findByBuyer(buyer);
    }
//pay order
    public String paidOrder(@RequestBody long id){
        Orders orders = orderRepository.findById(id).get();
        if(orders !=null){
            orders.setStatus("paid");
            orderRepository.modifyById("paid",id);
            Express express = new Express();
            express.setId(array[index++]);
            express.setProductId(orders.getProductId());
            express.setProductName(orders.getProductName());
            ExpressHalfway expressHalfway = new ExpressHalfway();
            Date date = new Date();
            expressHalfway.setTime(date);
            expressHalfway.setStatus("CREATE");
            expressHalfway.setAddress(orders.getAddress());
            List<ExpressHalfway> expressHalfwayList = new ArrayList<ExpressHalfway>();
            expressHalfwayList.add(expressHalfway);
            express.setHalfway(expressHalfwayList);
            express.setQuantity(orders.getQuantity());
            orders.setExpress(express);
            orderRepository.save(orders);
            expressRepository.save(express);
            return "pay success";
        }
        throw   new NotFoundEx(id,"orders");
    }
    //
    public  String undoOrder(@RequestBody long id){
        Orders orders = orderRepository.findById(id).get();
        if (orders !=null){
            orders.setExpress(null);
            orders.setStatus("undo");
            orderRepository.save(orders);

            return "undo success";
        }
        throw   new NotFoundEx(id,"orders");

    }
    public  String finishOrder(@RequestBody long id){
        Orders orders = orderRepository.findById(id).get();
        if (orders !=null){

            orderRepository.modifyById("finish",id);
            return "finish success";
        }
        throw   new NotFoundEx(id,"orders");
    }


}
