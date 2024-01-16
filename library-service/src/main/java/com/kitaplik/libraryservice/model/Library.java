package com.kitaplik.libraryservice.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
	
	@Id
	@Column(name="library_id")
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@ElementCollection
	private List<String> userBook;

}
