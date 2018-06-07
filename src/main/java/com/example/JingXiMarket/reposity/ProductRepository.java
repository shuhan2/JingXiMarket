package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    //查询名字是*的product

    //查询Id是*的product
//    Product findById(Long Id);
    //addproduct
//模糊查询

    Product findByNameAndDescriptionLike(String name,String description);
    //新增



}