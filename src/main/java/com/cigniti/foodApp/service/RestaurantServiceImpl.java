package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Restaurant;
import com.cigniti.foodApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restRepo;

	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> restaurants = restRepo.findAll();

		return restaurants;
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		restRepo.save(restaurant);
		return restaurant;
	}

	@Override
	public void deleteRestaurant(int restId) {
		restRepo.deleteById(restId);

	}

	@Override
	public Restaurant findByRestId(int restId) {
		Optional<Restaurant> result = restRepo.findById(restId);
		Restaurant restaurant = null;

		if (result.isPresent()) {
			restaurant = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + restId);
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> searchByName(String seachWord) {
		
		return restRepo.findByRestNameContainsAllIgnoreCase(seachWord);
	}

}
