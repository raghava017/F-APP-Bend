package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

	public List<Restaurant> getAllRestaurants();
	
	public Restaurant saveRestaurant(Restaurant restaurant);
	
	public Restaurant findByRestId(int restId);
	
	public void deleteRestaurant(int restId);
	
	public List<Restaurant> searchByName(String seachWord);
	

}
