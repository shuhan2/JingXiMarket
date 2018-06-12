package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
//模糊查询
@Query(value = "select * from Product where name like %?1% and description like %?2%",nativeQuery = true)
List<Product> findByNameAndDescriptionLike(String name, String description);
    //新增
    Product findByProductName(String name);



}