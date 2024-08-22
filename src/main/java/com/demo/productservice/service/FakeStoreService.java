package com.demo.productservice.service;

import com.demo.productservice.dto.response.FakeStoreResponseDTO;
import com.demo.productservice.model.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * Service returns the model and not the DTO to make the service method more reusable.
 * 1. Service operates upon models.
 * 2. DTO is specific to controller methods as it has to return response to client in a specific manner.
 * So service returns the complete model.
 */
@Service
public class FakeStoreService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductById(Long id) {

        ResponseEntity<FakeStoreResponseDTO> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/"+id,
                        FakeStoreResponseDTO.class);

        FakeStoreResponseDTO fakeStoreResponseDTO = response.getBody();
        if (Objects.nonNull(fakeStoreResponseDTO)) {
            return fakeStoreResponseDTO.toProduct(fakeStoreResponseDTO);
        }

        return null;
    }

    @Override
    public void createProduct() {

    }
}
