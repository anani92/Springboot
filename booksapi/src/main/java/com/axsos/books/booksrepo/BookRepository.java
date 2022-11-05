package com.axsos.books.booksrepo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.books.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
    void delete(Book book);
}
