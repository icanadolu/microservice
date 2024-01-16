package com.kitaplik.bookservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.service.BookService;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/book")
@AllArgsConstructor
@Validated
@Slf4j
public class BookController {

	//Logger logger = LoggerFactory.getLogger(BookController.class);
	private final BookService bookService;

	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBook() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookDto> getBookByIsbn(@PathVariable @NotEmpty String isbn) {
		
		log.info("Book requested by isbn:  " + isbn);
		return ResponseEntity.ok(bookService.findByIsbn(isbn));
	}

	@GetMapping("/book/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String bookId) {
		return ResponseEntity.ok(bookService.findBookDetailsById(bookId));
	}

	
}
