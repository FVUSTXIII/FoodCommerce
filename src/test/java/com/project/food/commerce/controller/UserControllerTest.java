package com.project.food.commerce.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.dto.UserResponseDTO;
import com.project.food.commerce.entity.User;
import com.project.food.commerce.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	UserRequestDTO userRequestDTO;
	UserResponseDTO userResponseDTO;
	
	User user;
	
	@BeforeEach
	public void setUp()
	{
		userRequestDTO = new UserRequestDTO();
		userRequestDTO.setUserName("Weon");
		userRequestDTO.setPassword("la wea fomme qliao");
		
		user = new User();
		user.setUserId(1);
		user.setUserName("Weon");
		user.setPassword("la wea fomme qliao");
		
	}
	
	@Test
	public void loginUser() throws Exception
	{
		when(userService.loginUser(userRequestDTO)).thenReturn(userResponseDTO);
		
		mockMvc.perform(post("/login")
				.content(asJsonString(userRequestDTO))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.userId").value(1))
		.andExpect(jsonPath("$.ResponseDTO.message").value("User Login Success"))
		.andExpect(jsonPath("$.ResponseDTO.statusCode").value(200));
	}

	public String asJsonString(UserRequestDTO userRequestDTO2) {
		try {
			return new ObjectMapper().writeValueAsString(userRequestDTO);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
