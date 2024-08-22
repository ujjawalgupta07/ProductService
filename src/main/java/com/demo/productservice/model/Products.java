package com.demo.productservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Products {

    private Long id;
    private String title;
    private String description;
    private Float price;
    private String imageUrl;
    private Categories category;
}
