package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Restaurant;
import com.cigniti.foodApp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://20.235.64.55:3000")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService restService;

	@GetMapping("/list")
	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> restaurants = restService.getAllRestaurants();
		return restaurants;

	}

	@PostMapping("/save")
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		restService.saveRestaurant(restaurant);

		return restaurant;

	}

	@PutMapping("/edit")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		restService.saveRestaurant(restaurant);

		return restaurant;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Restaurant restaurant = restService.findByRestId(id);
		if (restaurant == null) {
			throw new RuntimeException("Restaurant not found with id" + id);
		}

		restService.deleteRestaurant(id);
		return "Deleted restaurant with id :" + id;
	}
	
	@GetMapping("/search/{name}")
	public List<Restaurant> search(@PathVariable String name){
		
		return restService.searchByName(name);
	}
	

}
