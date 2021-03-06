package com.project.food.commerce.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.dto.UserDetailsDTO;
import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.dto.UserResponseDTO;
import com.project.food.commerce.entity.User;
import com.project.food.commerce.exception.UserNotFoundException;
import com.project.food.commerce.repository.UserRepository;
import com.project.food.commerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponseDTO loginUser(UserRequestDTO userRequestDTO) {
		User user = userRepository.findByuserNameAndPassword(userRequestDTO.getUserName(), userRequestDTO.getPassword());
		if(user==null)
			{
			throw new UserNotFoundException("User Not Found with the given credentials: "+userRequestDTO.getUserName()+" Password "+userRequestDTO.getPassword());
			}
		ResponseDTO responseDTO = new ResponseDTO("User Login Success", 200);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUserId(user.getUserId());
		userResponseDTO.setResponseDTO(responseDTO);
		return userResponseDTO;

	}

	@Override
	public UserDetailsDTO getUserDetails(Integer userId) {
		UserDetailsDTO userDetailsDTO = userRepository.findByUserId(userId);
		ResponseDTO responseDTO = new ResponseDTO("User Information Fetched Successfully", 200);
		userDetailsDTO.setResponseDTO(responseDTO);
		return userDetailsDTO;
	}

}
