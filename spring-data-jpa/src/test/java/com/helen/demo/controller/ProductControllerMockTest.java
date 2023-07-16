package com.helen.demo.controller;

import com.helen.demo.entity.Product;
import com.helen.demo.service.ProductService;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = {ProductService.class})
class ProductControllerMockTest {

    @MockBean
    private ProductService productService;

    @Autowired
    MockMvc mockMvc;


    @Test
    void getHello_printHello() throws Exception {

        this.mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "Hello"
                )));
    }

    @Test
    void getProductByID_ID1_ReturnProduct() throws Exception {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42));
        when(this.productService.getProductByID(1)).thenReturn(product);
        this.mockMvc.perform(get("/products/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "{\"id\":1,\"name\":\"Name\",\"price\":42,\"description\":\"The characteristics of someone or something\"}"
                )));
    }
}

