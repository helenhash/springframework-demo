package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
@SpringBootTest
class ProductServiceTestV4 {

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
