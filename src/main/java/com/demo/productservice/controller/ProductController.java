package com.demo.productservice.controller;

import com.demo.productservice.model.Products;
import com.demo.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

/**
 * Controller is responsible for 3 things ::
 * 1. validations on the request body / request params
 * 2. calling the service layer and get the details.
 * 3. Model to DTO Conversion. (Model is returned by Service).
 */
@RestController
public class ProductController {

    ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @PostMapping("/product")
    public void createProduct(){

    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @GetMapping("/products/{id}")
    public void getProductById(@PathVariable("id") Long productId){
        //validations
        if(null == productId){
           // throw exception
        }

        Products products = svc.getProductById(productId);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long productId){

    }
}
