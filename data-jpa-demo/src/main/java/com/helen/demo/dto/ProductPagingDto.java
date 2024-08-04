package com.helen.demo.dto;

import com.helen.demo.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductPagingDto {

    public long totalElement;
    public List<Product> products;

    public ProductPagingDto(long totalElement, List<Product> products) {
        this.totalElement = totalElement;
        this.products = products;
    }

}
