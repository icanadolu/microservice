package com.kitaplik.libraryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kitaplik.libraryservice.dto.BookDto;


@FeignClient(name="book-service",path="/v1/book")
public interface BookServiceClient {

	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookDto> getBookByIsbn(@PathVariable(value="isbn") String isbn);
	
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable(value="bookId") String bookId);
}
