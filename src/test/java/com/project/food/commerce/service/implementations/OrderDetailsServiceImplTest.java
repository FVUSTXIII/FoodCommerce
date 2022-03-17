package com.project.food.commerce.service.implementations;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.food.commerce.dto.OrderDetailProduct;
import com.project.food.commerce.dto.OrderRequestDTO;
import com.project.food.commerce.dto.OrderResponseDTO;
import com.project.food.commerce.dto.ResponseDTO;
import com.project.food.commerce.entity.OrderDetail;
import com.project.food.commerce.entity.Product;
import com.project.food.commerce.entity.ProductCategory;
import com.project.food.commerce.entity.Store;
import com.project.food.commerce.repository.OrderDetailRepository;
import com.project.food.commerce.repository.ProductRepository;
import com.project.food.commerce.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class OrderDetailsServiceImplTest {
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	OrderDetailRepository orderDetailRepository;
	
	@MockBean
	Store store;
	
	@InjectMocks
	OrderDetailsServiceImpl orderDetailsServiceImpl;
	
	//MOCK DTOS DEFINITION BLOCK
	
	OrderRequestDTO orderRequestDTO1;
	
	@BeforeEach
	public void setUp() {
		store = new Store();
		store.setStoreId(1);
		
		orderRequestDTO1 = new OrderRequestDTO();
		orderRequestDTO1.setStoreId(1);
		orderRequestDTO1.setUserId(2);
		Product mock_product1 = new Product();
		mock_product1.setIsAvailable(true);
		mock_product1.setProductCategory(ProductCategory.NOVEGGIE);
		mock_product1.setProductDescription("NO VEGGIE PRODUCT DESCRIPTION EXAMPLE");
		mock_product1.setProductId(1);
		mock_product1.setProductName("NO VEGGIE PRODUCT NAME");
		mock_product1.setProductPrice(810.50);
		mock_product1.setStore(store);
		Product mock_product2 = new Product();
		mock_product2.setIsAvailable(true);
		mock_product2.setProductCategory(ProductCategory.VEGGIE);
		mock_product2.setProductDescription("VEGGIE PRODUCT DESCRIPTION EXAMPLE");
		mock_product2.setProductId(2);
		mock_product2.setProductName("VEGGIE PRODUCT NAME");
		mock_product2.setProductPrice(81.50);
		mock_product2.setStore(store);
		
		List<OrderDetailProduct> FormattedProducts = new ArrayList<>();		
		List<Product> products = List.of(mock_product1, mock_product2);
		store.setProduct(products);
		products.forEach(product -> {
			OrderDetailProduct ODP = new OrderDetailProduct();
			ODP.setProductId(product.getProductId());
			ODP.setProductPrice(product.getProductPrice());
			ODP.setProductQuantity(1);
			FormattedProducts.add(ODP);
		});
		orderRequestDTO1.setProductList(FormattedProducts);
		
	}
	
	
	@Test
	@DisplayName("Save Order Details: Success")
	public void saveOrderDetails() {
		when(orderDetailRepository.save(any(OrderDetail.class))).then(foo -> {
			OrderDetail od = foo.getArgument(0);
			od.setOrderDetailId(1);
			OrderResponseDTO response = new OrderResponseDTO();
			ResponseDTO responseDTO = new ResponseDTO("Order Placed Successfully", 200);
			response.setOrderNumber(od.getOrderDetailId().toString());
			response.setResponseDTO(responseDTO);
			return response;
		});
		OrderResponseDTO OrderResponseDTO =  orderDetailsServiceImpl.saveOrderDetails(orderRequestDTO1);
		assertNotNull(OrderResponseDTO);
	}
}
