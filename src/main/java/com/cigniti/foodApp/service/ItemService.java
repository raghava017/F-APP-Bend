package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Item;

import java.util.List;

public interface ItemService {

	public List<Item> findAll();

	public Item save(Item item);

	public Item findByItemId(int id);

	public void deleteByItemId(int id);

	public List<Item> findByRestaurantId(int id);

	public List<Item> findByCategoryId(int id);
	
	public List<Item> searchByName(String searchWord);
}
