package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.ItemAvailability;
import com.cigniti.foodApp.repository.ItemAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemAvailabilityServiceImpl implements ItemAvailabilityService {

	@Autowired
	ItemAvailabilityRepository itemAvailRepo;

	@Override
	public List<ItemAvailability> findAll() {
		List<ItemAvailability> itemAvailList = itemAvailRepo.findAll();
		return itemAvailList;
	}

	@Override
	public ItemAvailability save(ItemAvailability itemAvailability) {
		itemAvailRepo.save(itemAvailability);
		return itemAvailability;
	}

	@Override
	public ItemAvailability findByItemAvailId(int id) {
		Optional<ItemAvailability> result = itemAvailRepo.findById(id);
		ItemAvailability itemAvailability = null;

		if (result.isPresent()) {
			itemAvailability = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + id);
		}

		return itemAvailability;
	}

	@Override
	public void deleteByItemAvailId(int id) {
		itemAvailRepo.deleteById(id);

	}

}
