package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Item;
import com.cigniti.foodApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://20.235.64.55:3000")
@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping("/list")
	public List<Item> getAllItems() {

		List<Item> items = itemService.findAll();
		return items;

	}

	@PostMapping("/save")
	public Item saveItem(@RequestBody Item item) {
		itemService.save(item);

		return item;

	}

	@PutMapping("/edit")
	public Item updateItem(@RequestBody Item item) {
		itemService.save(item);

		return item;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Item item = itemService.findByItemId(id);
		if (item == null) {
			throw new RuntimeException("Item not found with id" + id);
		}

		itemService.deleteByItemId(id);
		return "Deleted item with id :" + id;
	}

	@GetMapping("/list/{id}")
	public List<Item> getByRestaurantId(@PathVariable int id) {

		List<Item> items = itemService.findByRestaurantId(id);
		return items;
	}

	@GetMapping("/listc/{id}")
	public List<Item> getByCategoryId(@PathVariable int id) {

		List<Item> items = itemService.findByCategoryId(id);
		return items;
	}
	
	@GetMapping("/search/{name}")
	public List<Item> search(@PathVariable String name){
		
		return itemService.searchByName(name);
	}

}
