package com.axsos.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.books.booksrepo.BookRepository;
import com.axsos.books.model.Book;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Book book) {
    	bookRepository.delete(book);
    }
	public Book updateBook(Long id, Book book) {
		Book bookToUpdate = this.findBook(id);
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setDescription(book.getDescription());
		bookToUpdate.setLanguage(book.getLanguage());
		bookToUpdate.setNumberOfPages(book.getNumberOfPages());
		bookRepository.save(bookToUpdate);
		return bookToUpdate;
	}
}