package com.axsos.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productscategories.models.Category;
import com.axsos.productscategories.models.Product;
import com.axsos.productscategories.service.AppService;

@Controller
public class appController {
	@Autowired
	private final AppService appService;
	
	public appController(AppService appService) {
		this.appService = appService;
	}
	@GetMapping("/")
	public String homePage(Model model) {
		List <Product> allProducts = appService.allProducts();
		List <Category> allCategories = appService.allCategories();

		model.addAttribute("allProducts", allProducts);
		model.addAttribute("allCategories", allCategories);
		return "home.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/products/new")
	public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		}
		else {
			appService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/product/{product_id}")
	public String viewProduct(@PathVariable("product_id") Long productID, Model model) {
		Product product = appService.findProduct(productID);
		List <Category> categoriesNotContaining = appService.categoriesWithoutProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("categoriesNotContaining", categoriesNotContaining);
		return "viewproduct.jsp";
		
	}
	
	
	@PostMapping("/product/addcategory")
	public String addCategoryToProduct(@RequestParam("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
		Product product = appService.findProduct(productId);
		Category category = appService.findCategory(categoryId);
		List <Category> productCategories = product.getCategories();
		productCategories.add(category);
		product.setCategories(productCategories);
		appService.save(product);
		return "redirect:/product/" + product.getId();
		
	}
	

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/categories/new";
		}
		else {
			appService.createCategory(category);
			return "redirect:/";
		}
	}
	@GetMapping("/category/{category_id}")
	public String viewCategory(@PathVariable("category_id") Long categoryId, Model model) {
		Category category = appService.findCategory(categoryId);
		List <Product> productsNotContaining = appService.productsWithoutCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("productsNotContaining", productsNotContaining);

		return "viewcategory.jsp";
		
	}
	
	
	@PostMapping("/category/addproduct")
	public String addProductToCategory(@RequestParam("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
		Product product = appService.findProduct(productId);
		Category category = appService.findCategory(categoryId);
		List <Product> categoryProducts = category.getProducts();
		categoryProducts.add(product);
		category.setProducts(categoryProducts);
		appService.save(category);
		return "redirect:/category/" + category.getId();
		
	}
}
