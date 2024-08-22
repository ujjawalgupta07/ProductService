package com.demo.productservice.controller;

import com.demo.productservice.dto.response.GetAllProductsResponseDTO;
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

    ProductService productService;

    public ProductController(ProductService svc) {
        this.productService = svc;
    }

    @PostMapping("/product")
    public void createProduct(){

    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @GetMapping("/products/{id}")
    public GetAllProductsResponseDTO getProductById(@PathVariable("id") String productId){
        //validations
        if(null == productId){
           // throw exception
        }
        Products products = productService.getProductById(Long.valueOf(productId));
        return convertProductToDTO(products);
    }

    private GetAllProductsResponseDTO convertProductToDTO(Products products) {
        return GetAllProductsResponseDTO.builder()
                    .id(products.getId())
                    .title(products.getTitle())
                    .description(products.getDescription())
                    .price(products.getPrice())
                    .imageUrl(products.getImageUrl())
                    .category(products.getCategory())
                .build();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long productId){

    }
}
