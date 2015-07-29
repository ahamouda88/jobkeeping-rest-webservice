package com.queue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class IdAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 6313903570316610980L;

	public IdAlreadyExistsException(long id) {
		super("Employee with Id: '" + id + "' already exists.");
	}
}
