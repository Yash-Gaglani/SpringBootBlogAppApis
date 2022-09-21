package com.blogapp.main.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.main.entities.User;
import com.blogapp.main.exceptions.ResourceNotFoundException;
import com.blogapp.main.payloads.UserDTO;
import com.blogapp.main.repositories.UserRepository;
import com.blogapp.main.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository user_repo; 
//	We are autowiring the interface without any implememtation class which is something strange
//	Class Name: jdk.proxy2.$Proxy99 this class is made at runtime
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		User user = this.dtoToUser(userdto);
		user_repo.save(user);
		return this.userToDto(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, int id) {
		
		User user = user_repo.findById(id).orElseThrow( () -> new ResourceNotFoundException("User" , "id" , id));
		
		user.setName(userdto.getName());
		user.setAbout(userdto.getAbout());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		
		User updated_user = user_repo.save(user);
		
		return userToDto(updated_user);
	}

	@Override
	public UserDTO getUserById(int id) {
		User user = user_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id",id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> user_list = user_repo.findAll();
		List<UserDTO> dto_list = user_list.stream().map(user->userToDto(user)).collect(Collectors.toList());
		return dto_list;
	}

	@Override
	public void deleteUser(int id) {
		User user = user_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id",id));
		user_repo.delete(user);
	}
	
//	Now we have created a DTO to selectively expose some information to API but the problem is that while 
//	passing to the database we need to convert into data object so we use model mapper or create the functions
	
	private User dtoToUser(UserDTO udto) {
		User user = new User();
		user.setId(udto.getId());
		user.setName(udto.getName());
		user.setEmail(udto.getEmail());
		user.setAbout(udto.getAbout());
		user.setPassword(udto.getPassword());
		return user;
	}
	
	private UserDTO userToDto(User user) {
		UserDTO dto = new UserDTO();
		dto.setAbout(user.getAbout());
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		return dto;
	}

}
