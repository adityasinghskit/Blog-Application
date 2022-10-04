package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoPostFoundException.class)
	public ResponseEntity<ErrorDetails> ExpHandler1(NoPostFoundException ie,WebRequest wr){
		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(PostAreadyExistException.class)
	public ResponseEntity<ErrorDetails> ExpHandler2(PostAreadyExistException ie,WebRequest wr){
		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> ExpHandler3(NoHandlerFoundException ie,WebRequest wr){
		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> ExpHandler4(MethodArgumentNotValidException ie,WebRequest wr){
		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExpHandler5(Exception ie,WebRequest wr){
		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
}
