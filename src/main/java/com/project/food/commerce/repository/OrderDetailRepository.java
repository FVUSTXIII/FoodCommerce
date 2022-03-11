package com.project.food.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.Product;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>  {

	List<OrderDetail> findByUserId(Integer userId);
	
}
