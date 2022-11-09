package com.sshaun.springbootmall.dao.impl;

import com.sshaun.springbootmall.dao.ProductDao;
import com.sshaun.springbootmall.dao.ProductRowMapper;
import com.sshaun.springbootmall.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Products> getAll() {
        String sql = "select product_id,product_name,category,image_url,price,stock,description,created_date,last_modified_date from product";
        Map<String,Object> map = new HashMap();
        RowMapper mapper = new ProductRowMapper();
        List<Products> list = namedParameterJdbcTemplate.query(sql,map,mapper);
        return list;
    }

    @Override
    public Products getById(Integer productId) {
        String sql = "select product_id,product_name,category,image_url,price,stock,description,created_date,last_modified_date from product where product_id = :product_id";
        Map<String,Object> map = new HashMap();
        map.put("product_id",productId);
        //RowMapper mapper = new ProductRowMapper();
        List<Products> list = namedParameterJdbcTemplate.query(sql,map, BeanPropertyRowMapper.newInstance(Products.class));
        return list.get(0);
    }

    @Override
    public String postProduct(Products products) {
        String sql = "insert into product(product_name,category,image_url,price,stock,description,created_date,last_modified_date) value (:product_name,:category,:image_url,:price,:stock,:description,:created_date,:last_modified_date)";
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",products.getProductName());
        map.put("category",products.getCategory());
        map.put("image_url",products.getImageUrl());
        map.put("price",products.getPrice());
        map.put("stock",products.getStock());
        map.put("description",products.getDescription());
        map.put("created_date",products.getCreatedDate());
        map.put("last_modified_date",products.getLastModifiedDate());
        namedParameterJdbcTemplate.update(sql,map);
        return "新增一個產品成功";
    }

    @Override
    public String putById(Integer productId, Products products) {
        String sql = "update product set category=:category,image_url=:image_url,price=:price,stock=:stock,description=:description,last_modified_date=:last_modified_date where product_id=:product_id";
        Map<String,Object> map = new HashMap<>();
        map.put("product_id",products.getProductId());
        map.put("category",products.getCategory());
        map.put("image_url",products.getImageUrl());
        map.put("price",products.getPrice());
        map.put("stock",products.getStock());
        map.put("description",products.getDescription());
        map.put("last_modified_date",products.getLastModifiedDate());
        namedParameterJdbcTemplate.update(sql,map);
        return "更新產品成功";
    }

    @Override
    public String deleteById(Integer productId) {
        String sql = "delete * from productId";
        Map<String,Object> map= new HashMap<>();
        map.put("product_id",productId);
        namedParameterJdbcTemplate.update(sql,map);
        return "刪除產品成功";
    }
}
