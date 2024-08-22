package com.demo.productservice.service;

import com.demo.productservice.model.Products;

public interface ProductService {

    public Products getProductById(Long id);

    public void createProduct();
}
