package com.project.food.commerce.service.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Optional;

import org.mockito.InjectMocks;


import com.project.food.commerce.dto.ProductRequestDTO;
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

		assertThrows(StoreNotFoundException.class, () -> productServiceImpl.saveProductDetails(productRequestDTO));
	}
}
