package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import com.helen.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceTestV2 {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Test
    void getAllProducts_ReturnListOfOneProduct() {
        Assertions.assertNotNull(productRepository);

        Mockito.when(productRepository.findAll()).thenReturn(List.of(new Product()));
        List<Product> products = productService.getAllProducts();
        Assertions.assertEquals(1, products.size());
    }

}
