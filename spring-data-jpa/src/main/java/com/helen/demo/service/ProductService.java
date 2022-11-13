package com.helen.demo.service;

import com.helen.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductByID(Integer productID);

    Product updateOrInsert(Product product);

    void delete(Integer productID);

}
