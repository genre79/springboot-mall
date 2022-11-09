package com.sshaun.springbootmall.controller;

import com.sshaun.springbootmall.dao.impl.ProductDaoImpl;
import com.sshaun.springbootmall.model.Products;
import com.sshaun.springbootmall.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mall")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductDaoImpl productDao;

    @GetMapping("/get")
    public List<Products> getAll(){
        return productService.getAll();
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<Products> getById(@PathVariable Integer productId){
        Products products = productService.getById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Products products){
        productService.postProduct(products);
        return ResponseEntity.status(HttpStatus.OK).body("新增產品成功");
    }

    @PutMapping("/put/{productId}")
    public ResponseEntity<String> putById(@PathVariable Integer productId,@RequestBody Products products){
        productService.putById(productId,products);
        return ResponseEntity.status(HttpStatus.OK).body("更新"+productId+"號產品成功");
    }

    public String deleteById(Integer productId){
        return "ok";
    }
}
