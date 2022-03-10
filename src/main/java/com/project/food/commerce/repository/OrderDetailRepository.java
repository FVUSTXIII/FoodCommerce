package com.project.food.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.food.commerce.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>  {

}
