package com.demo.productservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Categories {

    private Long id;
    private String title;
}
