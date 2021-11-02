package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findAllByCategories(Category category);
	
	public List<Product> findByCategoriesNotContains(Category category);
	
	public List<Product> findAll();
	
	
}
