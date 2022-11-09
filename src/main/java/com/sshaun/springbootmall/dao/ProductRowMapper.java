package com.sshaun.springbootmall.dao;

import com.sshaun.springbootmall.model.Products;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Products products = new Products();
        products.setProductId(resultSet.getInt("product_id"));
        products.setProductName(resultSet.getString("product_name"));
        products.setCategory(resultSet.getString("category"));
        products.setImageUrl(resultSet.getString("image_url"));
        products.setPrice(resultSet.getInt("price"));
        products.setStock(resultSet.getInt("stock"));
        products.setDescription(resultSet.getString("description"));
        products.setCreatedDate(resultSet.getDate("created_date"));
        products.setLastModifiedDate(resultSet.getDate("last_modified_date"));
        return products;
    }
}
