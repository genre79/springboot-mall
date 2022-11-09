package com.sshaun.springbootmall.service.impl;

import com.sshaun.springbootmall.dao.ProductDao;
import com.sshaun.springbootmall.dao.impl.ProductDaoImpl;
import com.sshaun.springbootmall.model.Products;
import com.sshaun.springbootmall.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductsService {

    @Autowired
    private ProductDao productDao;


    @Override
    public List<Products> getAll() {
        return productDao.getAll();

    }

    @Override
    public Products getById(Integer productId) {
        return productDao.getById(productId);
    }

    @Override
    public String postProduct(Products products) {
        return productDao.postProduct(products);
    }

    @Override
    public String putById(Integer productId, Products products) {
        return productDao.putById(productId,products);
    }

    @Override
    public String deleteById(Integer productId) {
        return productDao.deleteById(productId);
    }
}
