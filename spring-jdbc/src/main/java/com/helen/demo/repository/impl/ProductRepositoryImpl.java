package com.helen.demo.repository.impl;

import com.helen.demo.repository.ProductRepository;
import com.helen.demo.mapper.ProductMapper;
import com.helen.demo.view.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl extends JdbcDaoSupport implements ProductRepository {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void innitialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Product> findAll() {
        return this.getJdbcTemplate().query("select * from product",
                new ProductMapper());
    }

    @Override
    public Product findById(int id) {
        return this.getJdbcTemplate().queryForObject("select * from Product where product_id = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();
                        product.setId(rs.getInt("product_id"));
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getBigDecimal("price"));
                        product.setDescription(rs.getString("description"));
                        return product;
                    }
                }, new Object[]{id});
    }

    @Override
    public Product insert(Product product) {

        this.getJdbcTemplate().update("insert into Product(product_id, name, price, description) values (?, ?, ?, ?)",
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1, product.getId());
                        ps.setString(2, product.getName());
                        ps.setBigDecimal(3, product.getPrice());
                        ps.setString(4, product.getDescription());
                    }
                });
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        this.getJdbcTemplate().update("update Product set name = ?, price = ?, description = ? where product_id = ?",
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {

                        ps.setString(1, product.getName());
                        ps.setBigDecimal(2, product.getPrice());
                        ps.setString(3, product.getDescription());
                        ps.setInt(4, product.getId());
                    }
                });
        return product;
    }
}
