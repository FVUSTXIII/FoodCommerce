package com.project.food.commerce.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.food.commerce.dto.ProductClosedInterface;
import com.project.food.commerce.entity.Product;
 
@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {


 Page<Product> findByStoreStoreId(Integer userId, Pageable paging);
 
 ProductClosedInterface findProductByProductId( @Param("productId") Integer productId);

}