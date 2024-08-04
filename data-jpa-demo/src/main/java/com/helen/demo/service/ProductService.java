package com.helen.demo.service;

import com.helen.demo.dto.ProductPagingDto;
import com.helen.demo.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> getProductsWithPrice(BigDecimal priceMin, BigDecimal priceMax);

    List<Product> getProductsWithName(String name);

    List<Product> findProductIdIn(List<Integer> ids);

    ProductPagingDto getProductsWithPaging(BigDecimal priceMin, BigDecimal priceMax, int page, int pageSize);

    List<Product> getAllProducts();

    Product getProductByID(Integer productID);

    Product updateOrInsert(Product product);

    void delete(Integer productID);
}
