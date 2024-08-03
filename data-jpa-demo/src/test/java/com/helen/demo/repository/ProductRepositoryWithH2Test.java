package com.helen.demo.repository;

import com.helen.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryWithH2Test {

    @Autowired
    ProductRepository productRepository;

    @Test
    void save_a_product() {
        Product savedProd = new Product();
        savedProd.setName("Product 1 Test");
        savedProd.setPrice(BigDecimal.TEN);
        savedProd.setDescription("Product 1 Des");
        this.productRepository.save(savedProd);
    }

    @Test
    void givenUser_whenSaved_thenCanBeFoundById1() {
        List<Product>  p = this.productRepository.findProductNameLike("P");
        System.out.println(p.size());
    }
}
