package com.helen.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Optional;

import com.helen.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    /**
     * Method under test: {@link ProductServiceImpl#getProductByID(Integer)}
     */
    @Test
    void testGetProductByID() {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);
        Product actualProductByID = this.productServiceImpl.getProductByID(1);
        assertSame(product, actualProductByID);
        assertEquals("42", actualProductByID.getPrice().toString());
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#getProductByID(Integer)}
     */
    @Test
    void testGetProductByID2() {
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertNull(this.productServiceImpl.getProductByID(1));
        verify(this.productRepository).findById((Integer) any());
    }
}

