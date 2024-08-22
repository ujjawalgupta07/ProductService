package com.demo.productservice.service;

import com.demo.productservice.model.Products;
import org.springframework.stereotype.Service;

/**
 * Service returns the model and not the DTO to make the service method more reusable.
 * 1. Service operates upon models.
 * 2. DTO is specific to controller methods as it has to return response to client in a specific manner.
 * So service returns the complete model.
 */
@Service
public class FakeStoreService implements ProductService{


    @Override
    public Products getProductById(Long id) {

        return null;
    }

    @Override
    public void createProduct() {

    }
}
