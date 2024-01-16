package com.kitaplik.bookservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.exception.BookNotFoundException;
import com.kitaplik.bookservice.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository repository;

	public List<BookDto> getAllBooks() {
		return repository.findAll().stream().map(p -> {

			return BookDto.builder().id(p.getId()).author(p.getAuthor()).bookYear(p.getBookYear()).isbn(p.getIsbn())
					.pressName(p.getPressName()).title(p.getTitle()).build();

		}).collect(Collectors.toList());
	}

	public BookDto findByIsbn(String isbn) {
		return repository.getBookByIsbn(isbn).map(p -> BookDto.builder()
				.id(p.getId())
				.isbn(p.getIsbn())
				.build()
				)
				.orElseThrow(()->new BookNotFoundException("Book could not found by isbn"+isbn));
	}
	
	public BookDto findBookDetailsById(String id) {
		return repository.findById(id).map(p -> {

			return BookDto.builder().id(p.getId()).author(p.getAuthor()).bookYear(p.getBookYear()).isbn(p.getIsbn())
					.pressName(p.getPressName()).title(p.getTitle()).build();

		}).orElseThrow(() -> new BookNotFoundException("Book could not found by id:" + id));
	}
}
