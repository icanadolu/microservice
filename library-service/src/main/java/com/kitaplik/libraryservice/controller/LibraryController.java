package com.kitaplik.libraryservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitaplik.libraryservice.LibraryService;
import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.LibraryDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/library")
@Slf4j
@RequiredArgsConstructor
public class LibraryController {
	
	private final LibraryService libraryService; 
	
	
	@GetMapping("{id}")
	public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
		return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
	}
	
	
	@PostMapping
   public  ResponseEntity<LibraryDto>	 createLibray(){
	   return ResponseEntity.ok(libraryService.createLibrary());
   }
	
	@PutMapping
	public ResponseEntity<Void>  addBookToLibrary(@RequestBody AddBookRequest request){
		libraryService.addBookToLibrary(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<String>>  getAllLibraries(){
		return ResponseEntity.ok(libraryService.getAllLibraries());
	}

}
