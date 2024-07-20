package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import com.helen.demo.dto.ProductPagingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsWithPrice(BigDecimal priceMin, BigDecimal priceMax) {
        return productRepository.findByPriceGreaterThanAndPriceLessThan(priceMin, priceMax);
    }

    @Override
    public List<Product> getProductsWithName(String name) {
        return productRepository.findProductNameLike(name);
    }

    @Override
    public List<Product> findProductIdIn(List<Integer> ids) {
        return productRepository.findProductIdIn(ids);
    }

    @Override
    public ProductPagingDto getProductsWithPaging(BigDecimal priceMin, BigDecimal priceMax, int page, int pageSize) {
        //Find product with paging
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("name").descending());
        Page<Product> productPage = productRepository.findByPriceGreaterThan(priceMin, pageable);
        return new ProductPagingDto(productPage.getTotalElements(), productPage.getContent());
    }
}
