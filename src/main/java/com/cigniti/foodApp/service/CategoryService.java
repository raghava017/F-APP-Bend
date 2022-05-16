package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Category;

import java.util.List;

public interface CategoryService {

	public List<Category> getAllCategories();

	public Category saveCategory(Category category);

	public Category findByCategoryId(int categoryId);

	public void deleteCategory(int categoryId);
	
	public List<Category> search(String searchWord);

}
