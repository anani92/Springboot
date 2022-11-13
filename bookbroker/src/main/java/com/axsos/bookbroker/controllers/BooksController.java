package com.axsos.bookbroker.controllers;

import java.util.List;

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

import com.axsos.bookbroker.models.Book;
import com.axsos.bookbroker.models.User;
import com.axsos.bookbroker.service.BookService;
import com.axsos.bookbroker.service.UserService;

@Controller
public class BooksController {
	@Autowired
	private final BookService bookService;
	@Autowired
	private final UserService userService; 
	public BooksController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}

	@GetMapping("/books/home")
	public String welcomePage(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User loggedUser = (User) session.getAttribute("user");
		model.addAttribute("borrowedBooks", bookService.getBorrowedBooks(loggedUser.getId()));
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

		Book newBook = bookService.createBook(book);
		newBook.setUser(loggedUser);
		newBook.setBorrower(null);
		session.getAttribute("user");
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
		model.addAttribute("user", loggedUser);
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
	public String deleteBook(@RequestParam("bookid") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books/home";
	}

	@GetMapping("/books/dashbord")
	public String userDashbord(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User loggedUser = (User) session.getAttribute("user");
		System.out.println(loggedUser);
		System.out.println(loggedUser.getBorrowedBooks());
		List <Book> borrowedBooks = loggedUser.getBorrowedBooks();
		model.addAttribute("user", loggedUser);
		model.addAttribute("availableBooks", bookService.findAvailableBooks());
		model.addAttribute("borrowedBooks", borrowedBooks);

		return "dashbord.jsp";
	}

	@PutMapping("/books/borrow/{id}")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session,@RequestParam("borrowId") Long userid) {
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser == null) {
			return "redirect:/";
		}
		Book bookToBorrow = bookService.findBook(id);
		if (bookToBorrow.getBorrower() != null) {
			return "redirect:/books/home";
		}
		List <Book> borrowedBooks = loggedUser.getBorrowedBooks(); 
		borrowedBooks.add(bookToBorrow);
		bookToBorrow.setBorrower(loggedUser);
		loggedUser.setBorrowedBooks(borrowedBooks); 
		bookService.saveBook(bookToBorrow);
		return "redirect:/books/dashbord";
	}

	@PutMapping("/books/return/{id}")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser == null) {
			return "redirect:/";
		}
		
		List <Book> borrowedBooks = loggedUser.getBorrowedBooks();
		Book bookToReturn = bookService.findBook(id);
		bookToReturn.setBorrower(null);
		borrowedBooks.remove(bookToReturn);
		loggedUser.setBorrowedBooks(borrowedBooks);
		bookService.saveBook(bookToReturn);
		userService.save(loggedUser);
		return "redirect:/books/dashbord";
	}

}
