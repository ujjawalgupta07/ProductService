package com.demo.productservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FakeStoreProductDTO {

    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

}
