package com.cigniti.foodApp.repository;

import com.cigniti.foodApp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	List<Restaurant> findByRestNameContainsAllIgnoreCase(String searchWord);

}
