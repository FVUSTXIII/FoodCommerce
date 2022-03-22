package com.project.food.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.food.commerce.dto.ProductClosedInterface;
import com.project.food.commerce.dto.StoreOpenInterface;
import com.project.food.commerce.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
	
	//ProductClosedInterface findProductByProductId( @Param("storeId") Integer storeId);
	
	StoreOpenInterface findStoreByStoreId( @Param("storeId") Integer storeId);
	
	
}
