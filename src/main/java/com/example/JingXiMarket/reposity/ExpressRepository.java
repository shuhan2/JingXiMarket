package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressRepository extends JpaRepository<Express,Long> {
    //查询
//    Express findById(Long Id );


}
