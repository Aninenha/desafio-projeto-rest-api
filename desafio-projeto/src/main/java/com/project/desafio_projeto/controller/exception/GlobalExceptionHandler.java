package com.project.desafio_projeto.controller.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleBusinessException (IllegalArgumentException businessException) {
		return new ResponseEntity<>(businessException.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFoundException (NoSuchElementException notFoundException) {
		return new ResponseEntity<>(notFoundException.getMessage("Resource not found"), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleThrowableException (Throwable unexpectedException) {
		var message = "Unexpected error: see logs for details";
		logger.error(message, unexpectedException);
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
