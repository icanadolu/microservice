package com.kitaplik.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {

	private String id;

	private String title;

	private Integer bookYear;

	private String author;

	private String pressName;

	private String isbn;

}
