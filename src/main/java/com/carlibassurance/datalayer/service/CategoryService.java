package com.carlibassurance.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlibassurance.datalayer.model.Category;
import com.carlibassurance.datalayer.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Iterable<Category> getCategories(){
		return this.categoryRepository.findAll();
	}
	
	public Optional<Category> getCategory(Integer category_id){
		return this.categoryRepository.findById(category_id);
	}
	
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
}
