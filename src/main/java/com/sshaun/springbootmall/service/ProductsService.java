package com.sshaun.springbootmall.service;

import com.sshaun.springbootmall.dao.impl.ProductDaoImpl;
import com.sshaun.springbootmall.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ProductsService {


    public List<Products> getAll();

    public Products getById(Integer productId);

    public String postProduct(Products products);

    public String putById(Integer productId,Products products);

    public String deleteById(Integer productId);
}
