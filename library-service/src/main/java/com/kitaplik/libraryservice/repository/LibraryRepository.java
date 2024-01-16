package com.kitaplik.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitaplik.libraryservice.model.Library;

public interface LibraryRepository extends JpaRepository<Library, String> {

}
