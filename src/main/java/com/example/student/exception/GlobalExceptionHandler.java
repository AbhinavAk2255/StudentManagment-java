package com.example.student.exception;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourseNotFound(
			ResourceNotFoundException e) {
		
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 404);
		error.put("error", "Not Found");
		error.put("message", e.getMessage());
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationErrors(
			MethodArgumentNotValidException e) {
		
		Map<String, Object> error = new HashMap<>();
		Map<String, Object> validationErrors = new HashMap<>();
		
		e.getBindingResult()
			.getFieldErrors()
			.forEach(fieldError -> 
			validationErrors.put(
					fieldError.getField(),
					fieldError.getDefaultMessage()
			)
			);
		
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 400);
		error.put("error", "Bad Request");
		error.put("message", "Validation failed");
		error.put("errors", validationErrors);
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(error);
	
	}
}

