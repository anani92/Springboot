package com.axsos.bookbroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.bookbroker.models.Book;

@Repository
public interface BooksRepo extends CrudRepository<Book, Long>{
	List <Book> findAll();
	List <Book> findAllByborrowerIsNotNull();
	List <Book> findAllByborrowerIsNull();
	
}