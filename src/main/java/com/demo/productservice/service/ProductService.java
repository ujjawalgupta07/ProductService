package com.demo.productservice.service;

import com.demo.productservice.model.Products;

import java.util.List;

public interface ProductService {

    Products getProductById(Long id);

    Products createProduct(String title,
                          String description,
                          String category,
                          String price,
                          String image);


    List<Products> getAllProducts();
}
