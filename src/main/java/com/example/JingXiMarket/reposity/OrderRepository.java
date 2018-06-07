package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> ,CrudRepository<Order,Long> {
    //查询订单
//    Order findById(Long Id);
    List<Order> findByBuyer(String buyer);
    //支付订单
    //撤销订单
    @Modifying
    @Query("update Order order set order.status = ?1  where order.Id = ?2")
    int modifyById(String status,Long Id);
     //search




}
