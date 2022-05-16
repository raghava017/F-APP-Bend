package com.cigniti.foodApp.repository;

import com.cigniti.foodApp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByRestId(int id);

	List<Item> findByCategoryId(int id);
	
	List<Item> findByItemNameContainsAllIgnoreCase(String searchWord);

}
