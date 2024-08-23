package com.demo.productservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FakeStoreGetAllProductsResponseDTO {

    private List<FakeStoreProductDTO> getAllProductsResponse;

}
