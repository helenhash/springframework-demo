package com.helen.springcachedemo.controller;

import com.helen.springcachedemo.entity.Product;
import com.helen.springcachedemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return ResponseEntity.ok(this.productService.getProductByID(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        //do some logic to save ...
        // ...
        return ResponseEntity.ok(this.productService.updateOrInsert(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        //do some logic to save ...
        product.setId(id);
        return ResponseEntity.ok(this.productService.updateOrInsert(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        this.productService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
