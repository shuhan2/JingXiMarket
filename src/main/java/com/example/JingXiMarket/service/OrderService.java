package com.example.JingXiMarket.service;

import com.example.JingXiMarket.entity.*;
import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.exception.OrderCreateEx;
import com.example.JingXiMarket.reposity.ExpressRepository;
import com.example.JingXiMarket.reposity.OrderRepository;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
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
    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    ExpressService expressService;
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
        Product product = productRepository.findById(productId);
        if (product!=null) {
            if (quantity > product.getQuantity()){
                throw   new OrderCreateEx("quantity can't more than product's reserve");
            }
            Date time = new Date();
            order.setCreateTime(time);
            order.setId((long) ++index);
            order.setProductId(productId);

            String productName = product.getProductName();
            order.setProductName(productName);
            order.setBuyer(buyer);
            order.setQuantity(quantity);
            order.setAddress("Wuh");
            order.setStatus("CREATED");
            order.setTotalPrice(product.getSinglePrice() * quantity);

            return orderRepository.save(order);
        }
     throw   new NotFoundEx(productId,"product");

    }

    //find
    public Orders checkOrderById(@PathVariable Long id){
        return  orderRepository.findById(id).get();
    }
    public List<Orders> checkOrdersByName(@PathVariable String buyer){
        return orderRepository.findByBuyer(buyer);
    }
    //update order
    public String updateOrderStatus(@PathVariable Long id,@PathVariable String status){
        Orders orders = orderRepository.findById(id).get();
        Product product = productRepository.findById(orders.getProductId()).get();
        Reserve reserve = reserveRepository.findByProductId(orders.getProductId());
        if(orders !=null){
            if (status.equals("paid")) {
                orders.setStatus("PAID");
                orderRepository.save(orders);
                Express express = new Express();

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
                express.setBuyer(orders.getBuyer());
                express.setStatus("NotSetOut");
                express.setCourier("Tony");
//            orders.setExpress(express);

                expressService.createExpress(express);
                return "pay success";
            }
            else if(status.equals("undo")){
                orders.setStatus("undo");
                orderRepository.save(orders);
                return "undo success";
            }

            else{
                throw new OrderCreateEx("status is not valid");
            }
        }
        throw   new NotFoundEx(id,"orders");
    }
    //




}
