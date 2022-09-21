package com.blogapp.main.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.blogapp.main.payloads.PersonalResponse;

@RestControllerAdvice //Advice for Rest Controllers 
public class GolbalExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<PersonalResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest req){
		String message = ex.getMessage() + " Request Description: " +req.getDescription(false);
		PersonalResponse response = new PersonalResponse(message,true);
		return new ResponseEntity<PersonalResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String field = ((FieldError)error).getField();
			String Message = error.getDefaultMessage();
			resp.put(field, Message);
		});
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
