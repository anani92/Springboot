package com.axsos.bookclub.controllers;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.services.BookClubService;

@Controller
public class BookClubController {
	@Autowired
	private final BookClubService bookService;

	public BookClubController(BookClubService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/welcome")
	public String welcomePage(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User loggedUser = (User) session.getAttribute("user");
		model.addAttribute("user", loggedUser);
		model.addAttribute("allbooks", bookService.allBooks());
		return "home.jsp";
	}

	@GetMapping("/books/new")
	public String NewBook(@ModelAttribute("book") Book book, HttpSession session) {
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser == null) {
			return "redirect:/";
		}
		
		return "newbook.jsp";
	}

	@PostMapping("/books/new")
	public String addNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		User loggedUser = (User) session.getAttribute("user");
		if (result.hasErrors()) {
			return "newbook.jsp";
		}
		
		Book newBook = bookService.createBook(book, loggedUser.getId());
		bookService.saveBook(newBook);
		return "redirect:/books/" + newBook.getId();
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser == null) {
			return "redirect:/";
		}
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		session.getAttribute("user");
		return "/showbook.jsp";
	}

	

	@GetMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser == null) {
			return "redirect:/";
		}
		Book book = bookService.findBook(id);
		model.addAttribute("bookToEdit", book);
		return "/edit.jsp";
	}

	@PutMapping("/books/edit/{id}")
	public String update(@Valid @ModelAttribute("bookToEdit") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books/" + book.getId();
		}
	}
	
	@DeleteMapping("/books/delete")
	public String deleteBook(@RequestParam("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/welcome";
	}

}
