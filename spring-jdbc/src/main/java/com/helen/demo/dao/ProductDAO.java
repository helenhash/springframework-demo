package com.helen.demo.dao;

import com.helen.demo.view.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();

    Product findById(int id);

    Product insert(Product product);

    Product update(int id, Product product);
}
