package com.axsos.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/index.jsp";
	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/new.jsp";
	}

	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}

	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/edit.jsp";
	}

	@PutMapping("/books/{id}")
	public String update(@Valid @ModelAttribute(value = "book") Book book, @PathVariable(value = "id") long id,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(id, book);
			return "redirect:/books";
		}
	}

	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		bookService.deleteBook(book);
		return "redirect:/books";
	}

}
