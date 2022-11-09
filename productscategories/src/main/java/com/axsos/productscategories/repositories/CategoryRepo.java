package com.axsos.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productscategories.models.Category;
import com.axsos.productscategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository <Category, Long>{
	List <Category> findAll();
	List <Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
	}
