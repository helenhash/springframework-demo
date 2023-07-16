package com.helen.springcachedemo.service;


import com.helen.springcachedemo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductByID(Integer productID);

    Product updateOrInsert(Product product);

    void delete(Integer productID);

}
