package com.demo.productservice.builder;

import com.demo.productservice.dto.response.FakeStoreProductDTO;
import com.demo.productservice.dto.response.ProductResponseDTO;
import com.demo.productservice.model.Categories;
import com.demo.productservice.model.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    /**
     * Converts the Incoming Object to ProductResponseDTO
     *
     * @param product : Products Entity Object
     * @return ProductResponseDTO
     */
    public ProductResponseDTO convertToProductResponseDTO(Products product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .category(product.getCategory())
                .build();
    }

    public Products mapToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Categories categories =
                Categories.builder()
                        .title(fakeStoreProductDTO.getCategory())
                        .build();

        Products product =
                Products.builder()
                        .title(fakeStoreProductDTO.getTitle())
                        .description(fakeStoreProductDTO.getDescription())
                        .price(Float.valueOf(fakeStoreProductDTO.getPrice()))
                        .imageUrl(fakeStoreProductDTO.getImage())
                        .category(categories)
                        .build();

        if(null != fakeStoreProductDTO.getId()){
            product.setId(Long.valueOf(fakeStoreProductDTO.getId()));
        }

        return product;
    }
}
