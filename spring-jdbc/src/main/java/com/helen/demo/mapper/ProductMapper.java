package com.helen.demo.mapper;

import com.helen.demo.view.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setDescription(rs.getString("description"));
        return product;
    }
}
