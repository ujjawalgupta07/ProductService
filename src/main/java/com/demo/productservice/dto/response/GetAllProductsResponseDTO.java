package com.demo.productservice.dto.response;

import com.demo.productservice.model.Categories;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetAllProductsResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Float price;
    private String imageUrl;
    private Categories category;
}
