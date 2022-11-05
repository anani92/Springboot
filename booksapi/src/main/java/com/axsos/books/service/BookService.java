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
    
    public void delete(Book book) {
    	bookRepository.delete(book);
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book bookToUpdate = this.findBook(id);
		bookToUpdate.setTitle(title);
		bookToUpdate.setDescription(desc);
		bookToUpdate.setLanguage(lang);
		bookToUpdate.setNumberOfPages(numOfPages);
		bookRepository.save(bookToUpdate);
		return bookToUpdate;
	}
}