package com.blogapp.main.services;


import com.blogapp.main.payloads.UserDTO;

import java.util.List;

public interface UserService {
	public UserDTO createUser(UserDTO user);
	public UserDTO updateUser(UserDTO user, int id);
	public UserDTO getUserById(int id);
	public List<UserDTO> getAllUsers();
	public void deleteUser(int id);
}
