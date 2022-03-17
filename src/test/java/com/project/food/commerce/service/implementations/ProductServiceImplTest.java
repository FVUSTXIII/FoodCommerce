package com.project.food.commerce.service.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.mockito.InjectMocks;


import com.project.food.commerce.dto.ProductRequestDTO;
import com.project.food.commerce.dto.UserRequestDTO;
import com.project.food.commerce.entity.Address;
import com.project.food.commerce.entity.Product;
import com.project.food.commerce.entity.ProductCategory;
import com.project.food.commerce.entity.Store;
import com.project.food.commerce.exception.StoreNotFoundException;
import com.project.food.commerce.repository.ProductRepository;
import com.project.food.commerce.repository.StoreRepository;
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	ProductRequestDTO productRequestDTO;
	ProductRequestDTO productRequestDTO2;
	ProductRequestDTO productRequestDTO3;
	
	Validator validator;
	
	Store store;
	
	@BeforeEach
	public void setUp() {
		productRequestDTO = new ProductRequestDTO();
		productRequestDTO.setProductName("Torta de jamón");
		productRequestDTO.setProductCategory("NOVEGGIE");
		productRequestDTO.setProductPrice(15.0);
		productRequestDTO.setProductDescription("Lonche bien vergas");
		productRequestDTO.setStoreId(4);
		productRequestDTO.setIsAvailable(true);
		
		Address a = new Address();
		a.setNameSt("Avenida siempre viva");
		a.setNeighborhood("Puerta de Fierro");
		a.setNumber("742");
		a.setZipCode("12345");
		store = new Store();
		store.setStoreId(4);
		store.setAddress(a);
		store.setStoreName("Lonches Perrones");
		store.setStoreRating(4.8);
		store.setStoreDescription("Las mejores tortas (lonches) del condado");
		store.setOpenTill(LocalTime.NOON);
		
		productRequestDTO2 = new ProductRequestDTO();
		productRequestDTO2.setProductName("Torta de jamón");
		productRequestDTO2.setProductCategory("NOVEGGIE");
		productRequestDTO2.setProductPrice(15.0);
		productRequestDTO2.setProductDescription("Lonche bien vergas");
		productRequestDTO2.setStoreId(2);
		productRequestDTO2.setIsAvailable(true);
		
		productRequestDTO3 = new ProductRequestDTO();
		productRequestDTO3.setProductName("");
		productRequestDTO3.setProductCategory("");
		productRequestDTO3.setStoreId(null);
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	@DisplayName("save product details: positive")
	public void saveProductDetailsTest() {
		when(storeRepository.findById(4)).thenReturn(Optional.of(store));
		when(productRepository.save(any(Product.class))).thenAnswer(i -> {
			Product product = i.getArgument(0);
			product.setProductId(1);
			return product;
		});		
		Product productResult = productServiceImpl.saveProductDetails(productRequestDTO);
		assertNotNull(productResult);
		assertEquals(4, productResult.getStore().getStoreId());
		assertEquals("Torta de jamón", productResult.getProductName());
		assertEquals(ProductCategory.NOVEGGIE, productResult.getProductCategory());
		assertEquals(15.0, productResult.getProductPrice());
	}
	
	@Test
	@DisplayName("Store found: negative")
	public void saveProductDetailsTest2() {
		when(storeRepository.findById(2)).thenReturn(Optional.empty());
		
		assertThrows(StoreNotFoundException.class, () -> productServiceImpl.saveProductDetails(productRequestDTO2));
	}
	
	@Test
	@DisplayName("Product empty arguments")
	public void saveProductDetailsTest3()
	{
		
		 Set<ConstraintViolation<ProductRequestDTO>> validations = validator.validate(productRequestDTO3);
		 assertFalse(validations.isEmpty());
	}
}
