package com.axsos.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axsos.books.model.Book;
import com.axsos.books.service.BookService;

@Controller

public class BooksController2 {
	@Autowired
	BookService bookService;
	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
		
	}
}	
