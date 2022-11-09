package com.axsos.productscategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.productscategories.models.Category;
import com.axsos.productscategories.models.Product;
import com.axsos.productscategories.repositories.CategoryRepo;
import com.axsos.productscategories.repositories.ProductRepo;

@Service
public class AppService {
	private final CategoryRepo categoryRepo;
	private final ProductRepo productRepo;
	
	public AppService(CategoryRepo categoryRepo, ProductRepo productRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	public List <Product> allProducts(){
		return productRepo.findAll();
	}
	public Product findProduct(Long id) {
		Optional <Product> product =  productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	
	
	
	public List <Category> allCategories(){
		return categoryRepo.findAll();
	}
	public Category findCategory(Long id) {
		Optional <Category> category =  categoryRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			return null;
		}
	}
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	
	public void save(Product product) {
		productRepo.save(product);
	}
	public void save(Category category) {
		 categoryRepo.save(category);
	}
	
	public List <Product> productsWithoutCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public List <Category> categoriesWithoutProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
}
