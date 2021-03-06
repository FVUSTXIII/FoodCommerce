package com.project.food.commerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.food.commerce.dto.UserDetailsDTO;
import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.dto.UserResponseDTO;
import com.project.food.commerce.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> loginUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
		UserResponseDTO userResponseDTO = userService.loginUser(userRequestDTO);
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getuserinfo/{userId}")
	public ResponseEntity<UserDetailsDTO> getUserInfo(@PathVariable("userId") Integer userId) {
		UserDetailsDTO userDetailsDTO = userService.getUserDetails(userId);
		
		return new ResponseEntity<UserDetailsDTO>(userDetailsDTO, HttpStatus.OK);
	}
	
	
}
