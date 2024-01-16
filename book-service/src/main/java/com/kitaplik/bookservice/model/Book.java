package com.kitaplik.bookservice.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String title;
	
	private Integer bookYear;
	
	private String author;
	
	private String pressName;
	
	private String isbn;
}
