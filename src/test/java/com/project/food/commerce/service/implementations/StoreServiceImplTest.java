package com.project.food.commerce.service.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.project.food.commerce.dto.StoreResponseDTO;
import com.project.food.commerce.entity.Address;
import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.Store;
import com.project.food.commerce.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class StoreServiceImplTest {
	
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	Page<Store> page;
	
	@InjectMocks
	StoreServiceImpl storeServiceImpl;
	
	Store store;
	Pageable paging;
	
	
	@BeforeEach
	public void setUp() {
		
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
		
		
		paging = PageRequest.of(0,5);
		System.out.println("NUMERO DE ELEMENTOS DE PAGE "+page.getTotalElements());
		//page = new PageImpl<Store>(store, paging, 10);
		//System.out.println(page.getContent());   
		
	}
	
	@Test
	@DisplayName("Get all store details")
	public void getAllStoreDetails1()
	{
		when(storeRepository.findAll(paging)).thenReturn(page);
		StoreResponseDTO storeResponseDTO = storeServiceImpl.getAllStoreDetails(0,5);
		assertNotNull(storeResponseDTO);
		//System.out.println(storeResponseDTO.getStoreList().get(0).getStoreName());
		//assertEquals(4, storeResponseDTO.getStoreList().get(0).getStoreId());
	
	}
	
	

}
