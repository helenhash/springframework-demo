package com.helen.demo.play;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import com.helen.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

@SpringBootTest
class ProductServiceSpyTest {

    @Autowired
    ProductServiceImpl productService;

    @SpyBean
    ProductRepository productRepository;

    @Test
    void getAllProducts_ReturnListOfOneProduct() {
        Assertions.assertNotNull(productRepository);
        Mockito.when(productRepository.findAll()).thenReturn(List.of(new Product()));
        List<Product> products = productService.getAllProducts();
        Assertions.assertEquals(1, products.size());
    }

//    @Test
//    void getProductByID_ID1_ReturnProduct() {
//        Product product = productService.getProductByID(1);
//        Assertions.assertEquals(1, product.getId());
//        Assertions.assertEquals("Phone Update", product.getName());
//    }

}
