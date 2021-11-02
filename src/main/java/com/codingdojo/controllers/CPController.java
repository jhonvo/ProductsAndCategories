package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;
import com.codingdojo.services.CPService;

@Controller
public class CPController {
	
	private CPService cpServ;
	
	public CPController (CPService cpServ) {
		this.cpServ = cpServ;
	}

	@RequestMapping("/")
	public String index(Model model) {
		List<Product> prod = cpServ.getProducts();
		List<Category> cat = cpServ.getCategories();
		model.addAttribute("categories", cat);
		model.addAttribute("products", prod);
		return "index.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute ("product") Product product){
		return "productnew.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute ("product") Product product,BindingResult result ){
		if (result.hasErrors()) {
            return "productnew.jsp";
        } else {
            cpServ.saveProduct(product);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categorynew.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "categorynew.jsp";
        } else {
            cpServ.saveCategory(category);
            return "redirect:/";
        }
	}
	
	@RequestMapping("products/{id}")
	public String showProduct(Model model, @ModelAttribute("join") Object object, @PathVariable("id") Long id ) {
		Product prod = cpServ.getProduct(id);
		List<Category> current = cpServ.getCatForProd(prod);
		List<Category> available = cpServ.getCatNotInProd(prod);
		model.addAttribute("product", prod);
		model.addAttribute("current", current);
		model.addAttribute("available", available);
		return "product.jsp";		
	}
	
	@RequestMapping("categories/{id}")
	public String showCategory(Model model, @ModelAttribute("join") Object object, @PathVariable("id") Long id) {
		Category cat = cpServ.getCategory(id);
		List<Product> current = cpServ.getProdForCat(cat);
		List<Product> available = cpServ.getProdNotInCat(cat);
		model.addAttribute("category", cat);
		model.addAttribute("current", current);
		model.addAttribute("available", available);
		return "category.jsp";
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.PUT)
	public String updateProduct(Model model, @PathVariable("id") Long id, @RequestParam (value="id") Long catId ) {
		Product prod = cpServ.getProduct(id);
		Category cat = cpServ.getCategory(catId);
		List<Category> current = prod.getCategories();
		current.add(cat);
		prod.setCategories(current);
		cpServ.saveProduct(prod);
		return "redirect:/products/"+id;		
	}
	
	@RequestMapping(value="categories/{id}", method=RequestMethod.PUT)
	public String updateCategory(Model model, @PathVariable("id") Long id, @RequestParam (value="id") Long prodId ) {
		Product prod = cpServ.getProduct(prodId);
		Category cat = cpServ.getCategory(id);
		List<Product> current = cat.getProducts();
		current.add(prod);
		cat.setProducts(current);
		cpServ.saveProduct(prod);
		return "redirect:/categories/"+id;		
	}
		
}
