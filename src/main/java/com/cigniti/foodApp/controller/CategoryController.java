package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Category;
import com.cigniti.foodApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://20.219.35.173:3000")
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService catService;

	@GetMapping("/list")
	public List<Category> getAllRestaurants() {

		List<Category> categories = catService.getAllCategories();
		return categories;

	}

	@PostMapping("/save")
	public Category saveRestaurant(@RequestBody Category category, HttpServletRequest request) {

		request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		String ip = request.getRemoteAddr();
		category.setIpAddress(ip);
		catService.saveCategory(category);

		return category;

	}

	@PutMapping("/edit")
	public Category updateCategory(@RequestBody Category category) {
		catService.saveCategory(category);

		return category;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Category category = catService.findByCategoryId(id);
		if (category == null) {
			throw new RuntimeException("Category not found with id" + id);
		}

		catService.deleteCategory(id);
		return "Deleted category with id :" + id;
	}
	
	@GetMapping("/search/{name}")
	public List<Category> search(@PathVariable String name){
		
		return catService.search(name);
	}

}
