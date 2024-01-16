package com.kitaplik.libraryservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.BookDto;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {
	
	private final LibraryRepository libraryRepository;
	private final BookServiceClient  bookServiceClient;
	
	
	public LibraryDto getAllBooksInLibraryById(String id) {
		Library library = libraryRepository.findById(id).orElseThrow(()->new LibraryNotFoundException("Library could not found by id: "+id));
		LibraryDto libraryDto = new  LibraryDto(library.getId(),
				library.getUserBook().stream()
				.map(book-> bookServiceClient.getBookById(book).getBody())
				 .collect(Collectors.toList()));
		
		return libraryDto;
		}
	
	
 public LibraryDto	createLibrary(){
	 Library newLibrary = libraryRepository.save(new Library());
	 return LibraryDto.builder().id(newLibrary.getId()).build();
 }
 
  public void addBookToLibrary(AddBookRequest request) {
	  BookDto bookIdByIsbn = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody();
	  
	  Library library = libraryRepository.findById(request.getId())
			  .orElseThrow(()->new LibraryNotFoundException("Library could not found by id: "+request.getId()));
	  library.getUserBook().add(bookIdByIsbn.getId());
	  
	  libraryRepository.save(library);
  }
  
  
  public List<String> getAllLibraries() {

      return libraryRepository.findAll()
              .stream()
              .map(l -> l.getId())
              .collect(Collectors.toList());
  }
	
}
