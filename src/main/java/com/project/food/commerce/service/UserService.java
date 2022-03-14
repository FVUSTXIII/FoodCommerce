package com.project.food.commerce.service;

import com.project.food.commerce.dto.UserDetailsDTO;
import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO loginUser(UserRequestDTO userRequestDTO);

	UserDetailsDTO getUserDetails(Integer userId);

}
