package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	public List<Category> findAllByProducts(Product product);
	
	public List<Category> findByProductsNotContains(Product product);
	
	public List<Category> findAll();
}
