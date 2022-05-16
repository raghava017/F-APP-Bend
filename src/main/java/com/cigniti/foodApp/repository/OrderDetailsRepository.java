package com.cigniti.foodApp.repository;

import com.cigniti.foodApp.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

}
