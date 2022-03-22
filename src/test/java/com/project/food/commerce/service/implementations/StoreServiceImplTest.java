package com.project.food.commerce.service.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.project.food.commerce.dto.StoreResponseDTO;
import com.project.food.commerce.entity.Address;
import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.Product;
import com.project.food.commerce.entity.ProductCategory;
import com.project.food.commerce.entity.Store;
import com.project.food.commerce.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class StoreServiceImplTest {
	
	//@Autowired
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	Page<Store> page;
	
	@Mock
	List<Store> list1;
	
	@Mock
	Product producto1;
	
	@InjectMocks
	StoreServiceImpl storeServiceImpl;
	
	Store store;
	
	@Mock
	Pageable paging;
	
	
	@BeforeEach
	public void setUp() {
		
	
		list1= new ArrayList<Store>();
		Address a = new Address();
		a.setNameSt("Avenida siempre viva");
		a.setNeighborhood("Puerta de Fierro");
		a.setNumber("742");
		a.setZipCode("12345");
		
		//producto1 = new ArrayList<>();
		producto1= new Product();
        producto1.setIsAvailable(true);
        producto1.setProductCategory(ProductCategory.NOVEGGIE);
        producto1.setProductDescription("Producto unico");
        producto1.setProductName("Product example");
        producto1.setProductPrice(100.0);
        producto1.setProductId(1);
        List<Product> p = new ArrayList();
		p.add(producto1);
		
		store = new Store();
		store.setStoreId(4);
		store.setAddress(a);
		store.setStoreName("Lonches Perrones");
		store.setStoreRating(4.8);
		store.setStoreDescription("Las mejores tortas (lonches) del condado");
		store.setOpenTill(LocalTime.NOON);
		store.setProduct(p);
		System.out.println(store.getStoreName());
		list1.add(store);
		
		//paging = PageRequest.of(0,5);
		System.out.println("NUMERO DE ELEMENTOS DE PAGE "+list1.get(0).getProduct().get(0).getProductName());
		//page = new PageImpl<Store>(store, paging, 10);
		//System.out.println(page.getContent());   
		
		
	}
	
	@Test
	@DisplayName("Get all store details")
	public void getAllStoreDetails1()
	{
		Pageable paging = PageRequest.of(0, 5);
		//when(storeRepository.findAll(paging)).thenReturn((Page<Store>) list1);
		when(storeRepository.findAll(paging).getContent()).thenReturn(list1);
		StoreResponseDTO storeResponseDTO = storeServiceImpl.getAllStoreDetails(0,5);
		//System.out.println(storeResponseDTO); 
		assertNotNull(storeResponseDTO);
		//System.out.println(storeResponseDTO.getStoreList().get(0).getStoreName());
		//assertEquals(4, storeResponseDTO.getStoreList().get(0).getStoreId());
	
	}
	
	

}
