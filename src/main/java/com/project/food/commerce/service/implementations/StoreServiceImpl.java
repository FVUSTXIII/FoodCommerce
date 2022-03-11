package com.project.food.commerce.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public StoreResponseDTO getAllStoreDetails(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		// TODO Auto-generated method stub
		Page<Store> storePage = storeRepository.findAll(paging);
		List<Store> storeList = storePage.getContent();
		List<StoreDetails> storeDetailsList = storeList.stream()
				.map(store -> {
						StoreDetails storeDetail = new StoreDetails();
						BeanUtils.copyProperties(store, storeDetail);
						return storeDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Store Details Fetch Success", 200);
		StoreResponseDTO storeResponseDto = new StoreResponseDTO();
		storeResponseDto.setStoreList(storeDetailsList);
		storeResponseDto.setResponseDTO(responseDTO);
		return storeResponseDto;
	}
	
}
