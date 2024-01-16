package com.kitaplik.bookservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class BookServiceApplication implements CommandLineRunner {
	private final BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Book book1 =      new Book(null,"Dünyanın Gözü", 2000, "Robert Jordan", "İthaki Yayınevi", "123456");
		Book book2 = new Book(null,"Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "456789");
		Book book3 = new Book(null,"Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "987654");

		List<Book> bookList = repository.saveAll(Arrays.asList(book1, book2, book3));

		System.out.println(bookList);
		
	}

}
