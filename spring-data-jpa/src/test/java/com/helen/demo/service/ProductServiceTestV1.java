package com.helen.demo.service;

import com.helen.demo.DataJpaDemoApplication;
import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = DataJpaDemoApplication.class)
class ProductServiceTestV1 {

	@Autowired
	ProductServiceImpl productService;

	@MockBean
	ProductRepository productRepository;

	@Test
	void getAllProducts_ReturnListOfOneProduct() {
		Assertions.assertNotNull(productRepository);

		Mockito.when(productRepository.findAll()).thenReturn(List.of(new Product()));
		List<Product> products = productService.getAllProducts();
		Assertions.assertEquals(1, products.size());
	}

}
