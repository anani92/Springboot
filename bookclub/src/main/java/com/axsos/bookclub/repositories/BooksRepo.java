package com.axsos.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.bookclub.models.Book;

@Repository
public interface BooksRepo extends CrudRepository<Book, Long>{
	List <Book> findAll();
	
	
}
