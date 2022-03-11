package com.project.food.commerce.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.dto.StoreDetails;
import com.project.food.commerce.dto.StoreResponseDTO;
import com.project.food.commerce.entity.Store;
import com.project.food.commerce.repository.StoreRepository;
import com.project.food.commerce.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public StoreResponseDTO getAllStoreDetails() {
		// TODO Auto-generated method stub
		List<Store> storeList = storeRepository.findAll();
		List<StoreDetails> storeDetailsList = storeList.stream()
				.map(store -> {
						StoreDetails storeDetail = new StoreDetails();
						BeanUtils.copyProperties(store, storeDetail);
						System.out.println(storeDetail.getOpenTill()+"    jggkhjhbkjhbkj    "+ store.getOpenTill());
						return storeDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Store Details Fetch Success", 200);
		StoreResponseDTO storeResponseDto = new StoreResponseDTO();
		storeResponseDto.setStoreList(storeDetailsList);
		storeResponseDto.setResponseDTO(responseDTO);
		return storeResponseDto;
	}
	
}
