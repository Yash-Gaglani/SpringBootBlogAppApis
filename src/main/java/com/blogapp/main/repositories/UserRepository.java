package com.blogapp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
