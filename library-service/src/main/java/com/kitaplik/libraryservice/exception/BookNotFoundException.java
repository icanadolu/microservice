package com.kitaplik.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
	private ExceptionMessage exceptionMessage;

		

	public BookNotFoundException(String message, ExceptionMessage exceptionMessage) {
		super(message);
		this.exceptionMessage = exceptionMessage;
	}

	public BookNotFoundException(ExceptionMessage exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessage getExceptionMessage() {
		return exceptionMessage;
	}

	
	
}
