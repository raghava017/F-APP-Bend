package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Item;
import com.cigniti.foodApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;

	@Override
	public List<Item> findAll() {
		List<Item> items = itemRepo.findAll();
		return items;
	}

	@Override
	public Item save(Item item) {
		itemRepo.save(item);
		return item;

	}

	@Override
	public Item findByItemId(int itemId) {
		Optional<Item> result = itemRepo.findById(itemId);
		Item item = null;

		if (result.isPresent()) {
			item = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + itemId);
		}

		return item;
	}

	@Override
	public void deleteByItemId(int id) {
		itemRepo.deleteById(id);

	}

	@Override
	public List<Item> findByRestaurantId(int id) {
		List<Item> items = itemRepo.findByRestId(id);
		return items;
	}

	@Override
	public List<Item> findByCategoryId(int id) {
		List<Item> items = itemRepo.findByCategoryId(id);
		return items;
	}

	@Override
	public List<Item> searchByName(String searchWord) {
		
		return itemRepo.findByItemNameContainsAllIgnoreCase(searchWord);
	}

}
