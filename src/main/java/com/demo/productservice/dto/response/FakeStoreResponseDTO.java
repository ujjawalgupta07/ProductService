package com.demo.productservice.dto.response;

import com.demo.productservice.model.Categories;
import com.demo.productservice.model.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {

    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Products toProduct(FakeStoreResponseDTO fakeStoreResponseDTO){
        Categories categories =
                Categories.builder()
                    .title(fakeStoreResponseDTO.getCategory())
                .build();

        Products product =
                Products.builder()
                        .title(fakeStoreResponseDTO.getTitle())
                        .description(fakeStoreResponseDTO.getDescription())
                        .price(Float.valueOf(fakeStoreResponseDTO.getPrice()))
                        .imageUrl(fakeStoreResponseDTO.getImage())
                        .category(categories)
                .build();

        if(null != fakeStoreResponseDTO.getId()){
            product.setId(Long.valueOf(fakeStoreResponseDTO.getId()));
        }

        return product;
    }
}
