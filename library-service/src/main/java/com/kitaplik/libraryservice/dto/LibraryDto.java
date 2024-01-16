package com.kitaplik.libraryservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryDto {
	private String id;
	private List<BookDto> userBookList;
}
