package com.helen.demo.controller;

import com.helen.demo.repository.ProductRepository;
import com.helen.demo.view.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        // return a static list of products for demo
//        List<Product> products = new ArrayList<>();
//        Product product1 = new Product();
//        product1.setId(1);
//        product1.setName("Phone");
//        product1.setPrice(BigDecimal.valueOf(100));
//        products.add(product1);

        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        //return a static product for demo
//        Product product1 = new Product();
//        product1.setId(1);
//        product1.setName("Phone");
//        product1.setPrice(BigDecimal.valueOf(100));
        return ResponseEntity.ok(this.productRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        //do some logic to save ...
        // ...
        return ResponseEntity.ok(this.productRepository.insert(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        //do some logic to save ...
        // ...
        return ResponseEntity.ok(this.productRepository.update(id, product));
    }
}
