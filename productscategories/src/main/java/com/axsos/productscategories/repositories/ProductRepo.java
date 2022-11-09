package com.axsos.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productscategories.models.Category;
import com.axsos.productscategories.models.Product;


@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {
	List <Product> findAll();
	List <Product> findAllByCategories(Category category);
	List <Product> findByCategoriesNotContains(Category category);}
