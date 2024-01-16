package com.kitaplik.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitaplik.bookservice.model.Book;

public interface BookRepository  extends JpaRepository<Book, String>{
  
	Optional<Book> getBookByIsbn(String isbn);
}
