package com.project.food.commerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.food.commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
