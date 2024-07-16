package com.helen.demo.view;

import com.helen.demo.entity.Product;

import java.util.List;

public class ProductPagingView {

    public long totalElement;
    public List<Product> products;

    public ProductPagingView(long totalElement, List<Product> products) {
        this.totalElement = totalElement;
        this.products = products;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



}
