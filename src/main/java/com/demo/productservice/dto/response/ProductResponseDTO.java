package com.demo.productservice.dto.response;

import com.demo.productservice.model.Categories;
import lombok.*;

@Getter
@Setter
@Builder
public class ProductResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Float price;
    private String imageUrl;
    private Categories category;
}
