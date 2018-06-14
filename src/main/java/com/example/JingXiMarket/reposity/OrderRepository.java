package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> ,CrudRepository<Orders,Long> {

    //查询订单
//    Orders findById(Long Id)
    List<Orders> findByBuyer(String buyer);
    //支付订单
    //撤销订单
    @Transactional
    @Modifying
    @Query("update Orders  set status =:status  where Id =:Id")
    int modifyById(@Param("status")String status,@Param("Id")Long Id);
     //search
    Orders findByProductId(Long productId);
    Orders findByExpressId(Long expressId);




}
