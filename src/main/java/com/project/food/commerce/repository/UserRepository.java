package com.project.food.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.food.commerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuserNameAndPassword(String userName, String password);
} //SELECT * FROM user where userName="userName" and password="password";
