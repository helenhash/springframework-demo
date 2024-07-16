package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.view.ProductPagingView;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> getProductsWithPrice(BigDecimal priceMin, BigDecimal priceMax);

    List<Product> getProductsWithName(String name);

    List<Product> findProductIdIn(List<Integer> ids);

    ProductPagingView getProductsWithPaging(BigDecimal priceMin, BigDecimal priceMax, int page, int pageSize);
}
