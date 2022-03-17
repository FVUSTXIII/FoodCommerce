package com.project.food.commerce.service.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.dto.UserResponseDTO;
import com.project.food.commerce.entity.User;
import com.project.food.commerce.exception.UserNotFoundException;
import com.project.food.commerce.repository.UserRepository;

import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	UserRequestDTO userRequestDTO;
	UserRequestDTO userRequestDTO2;
	UserRequestDTO userRequestDTO3;
	UserResponseDTO userResponseDTO;
	
	Validator validator;
	
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
		
		userRequestDTO2 = new UserRequestDTO();
		userRequestDTO2.setUserName("ocyel");
		userRequestDTO2.setPassword("negative case");
		
		userRequestDTO3 = new UserRequestDTO();
		userRequestDTO3.setUserName("");
		userRequestDTO3.setPassword("");
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	@DisplayName("User login positive")
	public void loginUserTest()
	{
		when(userRepository.findByuserNameAndPassword("Weon","la wea fomme qliao")).thenReturn(user);
		
		UserResponseDTO userResponseDTO = userServiceImpl.loginUser(userRequestDTO);
		
		assertNotNull(userResponseDTO);
		assertEquals(1, userResponseDTO.getUserId());
		assertEquals("User Login Success", userResponseDTO.getResponseDTO().getMessage());
		assertEquals(200, userResponseDTO.getResponseDTO().getStatusCode());
		
	}
	
	@Test
	@DisplayName("User login negative")
	public void loginUserTest1()
	{
		when(userRepository.findByuserNameAndPassword("ocyel","negative case")).thenReturn(null);
		
		assertThrows(UserNotFoundException.class, () -> userServiceImpl.loginUser(userRequestDTO2));
	}
	
	@Test
	@DisplayName("User login empty arguments")
	public void loginUserTest2()
	{
		
		 Set<ConstraintViolation<UserRequestDTO>> validations = validator.validate(userRequestDTO3);
		 assertFalse(validations.isEmpty());
	}
}
