package com.project.food.commerce.controller;

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
import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@MockBean
	ProductService productService;
	
	@Autowired
	private MockMvc mockMvc;
	
	ProductRequestDTO productRequestDTO;
	
	@BeforeEach
	public void setUp()
	{
		productRequestDTO = new ProductRequestDTO();
		productRequestDTO.setProductName("Torta de jamón");
		productRequestDTO.setProductCategory("NOVEGGIE");
		productRequestDTO.setProductPrice(15.0);
		productRequestDTO.setProductDescription("Lonche bien vergas");
		productRequestDTO.setStoreId(4);
		productRequestDTO.setIsAvailable(true);
	}
	
	@Test
	public void saveProductDetails() throws Exception
	{
		mockMvc.perform(post("/products")
				.content(asJsonString(productRequestDTO))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(jsonPath("$.message").value("Product Save Success"))
		.andExpect(jsonPath("$.statusCode").value(200));
	}

	public String asJsonString(ProductRequestDTO productRequestDTO2) {
		try {
			return new ObjectMapper().writeValueAsString(productRequestDTO);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
