package com.helen.demo.repository;

import com.helen.demo.view.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(int id);

    Product insert(Product product);

    Product update(int id, Product product);
}
