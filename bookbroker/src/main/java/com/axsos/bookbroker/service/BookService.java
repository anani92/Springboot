package com.axsos.bookbroker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.bookbroker.models.Book;
import com.axsos.bookbroker.models.User;
import com.axsos.bookbroker.repositories.BooksRepo;

@Service
public class BookService {
	private final BooksRepo bookRepo;
	private final UserService userService;

	public BookService(BooksRepo bookRepo, UserService userService) {
		this.userService = userService;
		this.bookRepo = bookRepo;
	}

	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	public Book findBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}

	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	public void saveBook(Book b) {
		bookRepo.save(b);
	}

	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	public void deleteBook(Long id) {
		Optional<Book> bookToDelete = bookRepo.findById(id);
		if (bookToDelete.isPresent()) {
			bookRepo.deleteById(id);
		}
	}

	public List<Book> getBorrowedBooks(Long userId) {
		User user = userService.findUserById(userId);

		return user.getBorrowedBooks();
	}

	public List<Book> findAllBorrowedBooks() {
		return bookRepo.findAllByborrowerIsNotNull();
	}

	public List<Book> findAvailableBooks() {
		return bookRepo.findAllByborrowerIsNull();
	}



}
