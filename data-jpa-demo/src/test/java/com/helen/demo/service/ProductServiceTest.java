package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import com.helen.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProductServiceImpl.class})
class ProductServiceTest {

	private static ArrayList<Product> productFromDB;

	@Autowired
	ProductServiceImpl productService;

	@MockBean
	ProductRepository productRepository;

	@BeforeAll
	static void init() {
		System.out.println("startup");
		Product p = new Product();
		p.setId(1);
		p.setName("Apple");
		productFromDB = new ArrayList<>(List.of(p));
	}

	@AfterAll
	static void teardown() {
		System.out.println("teardown");
		productFromDB.clear();
	}

	@Test
	void getAllProducts_ReturnListOfOneProduct() {
		Assertions.assertNotNull(productRepository);
		Mockito.when(productRepository.findAll()).thenReturn(productFromDB);
		List<Product> products = productService.getAllProducts();
		Assertions.assertEquals(1, products.size());
	}

	@Test
	void getProductByID_ID1_ReturnProduct() {
		Assertions.assertNotNull(productRepository);
		Product p = new Product();
		p.setId(1);
		p.setName("Apple");
		Mockito.when(this.productRepository.findById(1)).thenReturn(Optional.of(p));
		Product product = productService.getProductByID(1);
		Assertions.assertEquals(1, product.getId());
		Assertions.assertEquals("Apple", product.getName());
	}

	@Test
	void getProductByID_ID2_ReturnNull() {
		Assertions.assertNotNull(productRepository);
		Product p = new Product();
		p.setId(1);
		p.setName("Apple");
		Mockito.when(this.productRepository.findById(1)).thenReturn(Optional.of(p));
		Product product = productService.getProductByID(2);
		Assertions.assertNull(product);
	}
}
