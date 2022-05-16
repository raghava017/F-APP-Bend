package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Category;
import com.cigniti.foodApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository catRepo;

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = catRepo.findAll();
		return categories;
	}

	@Override
	public Category saveCategory(Category category) {
		catRepo.save(category);
		return category;
	}

	@Override
	public Category findByCategoryId(int categoryId) {
		Optional<Category> result = catRepo.findById(categoryId);
		Category category = null;

		if (result.isPresent()) {
			category = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + categoryId);
		}
		return category;
	}

	@Override
	public void deleteCategory(int categoryId) {
		catRepo.deleteById(categoryId);

	}

	@Override
	public List<Category> search(String searchWord) {
		
		return catRepo.findByCategoryNameContainsAllIgnoreCase(searchWord);
	}

}
