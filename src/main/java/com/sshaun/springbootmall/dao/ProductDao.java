package com.sshaun.springbootmall.dao;

import com.sshaun.springbootmall.model.Products;

import java.util.List;

public interface ProductDao {
    public List<Products> getAll();

    public Products getById(Integer productId);

    public String postProduct(Products products);

    public String putById(Integer productId,Products products);

    public String deleteById(Integer productId);
}
