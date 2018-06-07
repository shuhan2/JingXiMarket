package com.example.JingXiMarket.reposity;

import com.example.JingXiMarket.entity.Express;
import com.example.JingXiMarket.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Long> {
//    @Modifying
//    @Query()
}
