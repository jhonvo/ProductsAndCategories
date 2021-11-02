package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;
import com.codingdojo.repositories.CategoryRepository;
import com.codingdojo.repositories.ProductRepository;

@Service
public class CPService {
	private final ProductRepository pRep;
	private final CategoryRepository cRep;
	
	public CPService(ProductRepository pRep, CategoryRepository cRep ) {
		this.cRep = cRep;
		this.pRep = pRep;
	}
	
	public Product saveProduct(Product p) {
		return pRep.save(p);
	}
	
	public Category saveCategory(Category c) {
		return cRep.save(c);
	}
	
	public List<Product> getProducts(){
		return pRep.findAll();
	}
	
	public List<Product> getProdForCat(Category c){
		return pRep.findAllByCategories(c);
	}
	
	public List<Product> getProdNotInCat(Category c){
		return pRep.findByCategoriesNotContains(c);
	}
	
	public List<Category> getCategories(){
		return cRep.findAll();
	}
	
	public List<Category> getCatForProd(Product p){
		return cRep.findAllByProducts(p);
	}
	
	public List<Category> getCatNotInProd(Product p){
		return cRep.findByProductsNotContains(p);
	}
	
	public Product getProduct(Long id) {
		Optional<Product> prod = pRep.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		} else {
			return null;
		}
	}
	
	public Category getCategory(Long id) {
		Optional<Category> cat = cRep.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		} else {
			return null;
		}
	}


	
}
