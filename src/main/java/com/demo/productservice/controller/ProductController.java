package com.demo.productservice.controller;

import com.demo.productservice.builder.ProductMapper;
import com.demo.productservice.dto.request.CreateProductRequestDTO;
import com.demo.productservice.dto.response.ProductResponseDTO;
import com.demo.productservice.model.Products;
import com.demo.productservice.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller is responsible for 3 things ::
 * 1. validations on the request body / request params
 * 2. calling the service layer and get the details.
 * 3. Model to DTO Conversion. (Model is returned by Service).
 */
@RestController
public class ProductController {

    ProductService productService;
    ProductMapper productMapper;

    public ProductController(ProductService svc, ProductMapper mapper) {
        this.productService = svc;
        this.productMapper = mapper;
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){

        Products product = productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice(),
                createProductRequestDTO.getImage());

        return productMapper.convertToProductResponseDTO(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts(){
        List<Products> productList = productService.getAllProducts();
        if (CollectionUtils.isEmpty(productList)) {
            return null;
        }

        List<ProductResponseDTO> response = new ArrayList<>();

        for (Products p : productList) {
            response.add(productMapper.convertToProductResponseDTO(p));
        }

        return response;
    }

    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") String productId)
            throws BadRequestException {
        //validations
        if(null == productId){
           throw new BadRequestException("Product Id missing.");
        }
        Products products = productService.getProductById(Long.valueOf(productId));
        return productMapper.convertToProductResponseDTO(products);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long productId){

    }
}
