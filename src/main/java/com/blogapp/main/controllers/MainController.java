package com.blogapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.main.entities.User;
import com.blogapp.main.payloads.PersonalResponse;
import com.blogapp.main.payloads.UserDTO;
import com.blogapp.main.services.UserService;

@RestController
public class MainController {
	
	@Autowired
	UserService uimpl;
	
	@GetMapping("/home")
	public ResponseEntity<String> greet(){
		return new ResponseEntity<String>("Successful Build", HttpStatus.I_AM_A_TEAPOT);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> findbyid(@PathVariable int id){
		UserDTO user = uimpl.getUserById(id);
		return new ResponseEntity<UserDTO>(user, HttpStatus.FOUND);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> findall(){
		List<UserDTO> users =  uimpl.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.FOUND);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto){
		uimpl.createUser(dto);
		return null;
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto,@PathVariable int id){
		uimpl.updateUser(dto, id);
		return new ResponseEntity<UserDTO>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<PersonalResponse> deleteUser(@PathVariable int id){
		uimpl.deleteUser(id);
		return new ResponseEntity<PersonalResponse>(new PersonalResponse("User Deleted Success",true) , HttpStatus.OK);
	}
	
}
