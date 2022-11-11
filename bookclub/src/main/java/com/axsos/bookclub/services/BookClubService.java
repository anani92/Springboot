package com.axsos.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.repositories.BooksRepo;

@Service
public class BookClubService {
	private final BooksRepo bookRepo;
	private final UserService userService;

	public BookClubService(BooksRepo bookRepo, UserService userService) {
		this.userService = userService;
		this.bookRepo = bookRepo;
	}
	
	public List <Book> allBooks() {
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

	public Book createBook(Book b, Long userId) {
		User user = userService.findUserById(userId);
		b.setUser(user);
		return bookRepo.save(b);
	}

	public void saveBook(Book b) {
		bookRepo.save(b);
	}

	public Book updateBook(Book book) {
		return bookRepo .save(book);
	}
	
	public void deleteBook(Long id) {
		Optional <Book> bookToDelete = bookRepo.findById(id);
		if (bookToDelete.isPresent()) {
			bookRepo.deleteById(id);
		}
	}

}
