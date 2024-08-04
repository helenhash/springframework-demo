package com.helen.demo.service.impl;

import com.helen.demo.dto.ProductPagingDto;
import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import com.helen.demo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductByID(Integer productID) {
        Optional<Product> productOptional = this.productRepository.findById(productID);
        // or we can throw error.
        return productOptional.orElse(null);
    }

    @Override
    public Product updateOrInsert(Product product) {
        // in some case, we will implement some business in this layer
        Product saveProduct;
        if (product.getId() == null) {
            //insert
            saveProduct = this.productRepository.save(product);
        } else {
            //update
            Optional<Product> productOptional = this.productRepository.findById(product.getId());
            if (productOptional.isPresent()) {
//                Product oldProduct = productOptional.get();
//                oldProduct.setName(product.getName());
//                oldProduct.setDescription(product.getDescription());
//                oldProduct.setPrice(product.getPrice());
//                this.productRepository.save(oldProduct);

                // the other way
                saveProduct = this.productRepository.save(product);
            } else {
                // throw error because id does not exist.
                throw new IllegalArgumentException("Product does not exist");
            }
        }
        return saveProduct;
    }

    @Override
    public void delete(Integer productID) {
        Optional<Product> productOptional = this.productRepository.findById(productID);
        if (productOptional.isPresent()) {
            this.productRepository.deleteById(productID);
        } else {
            // throw error because id does not exist.
            throw new IllegalArgumentException("Product does not exist");
        }
    }
}
