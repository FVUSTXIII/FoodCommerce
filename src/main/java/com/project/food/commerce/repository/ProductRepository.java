package com.project.food.commerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.food.commerce.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}