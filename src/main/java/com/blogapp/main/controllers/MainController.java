package com.blogapp.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/home")
	public ResponseEntity<String> greet(){
		return new ResponseEntity<String>("Successful Build", HttpStatus.I_AM_A_TEAPOT);
	}
}
