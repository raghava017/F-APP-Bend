package com.cigniti.foodApp.repository;

import com.cigniti.foodApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
