package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.ItemAvailability;

import java.util.List;

public interface ItemAvailabilityService {

	public List<ItemAvailability> findAll();

	public ItemAvailability save(ItemAvailability itemAvailability);

	public ItemAvailability findByItemAvailId(int id);

	public void deleteByItemAvailId(int id);

}
