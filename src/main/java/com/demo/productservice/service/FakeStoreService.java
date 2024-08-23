package com.demo.productservice.service;

import com.demo.productservice.builder.ProductMapper;
import com.demo.productservice.dto.response.FakeStoreGetAllProductsResponseDTO;
import com.demo.productservice.dto.response.FakeStoreProductDTO;
import com.demo.productservice.model.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
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
    ProductMapper productMapper;

    public FakeStoreService(RestTemplate restTemplate, ProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.productMapper = mapper;
    }

    @Override
    public Products getProductById(Long id) {

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/"+id,
                        FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        if (Objects.nonNull(fakeStoreProductDTO)) {
            return productMapper.mapToProduct(fakeStoreProductDTO);
        }

        return null;
    }

    @Override
    public Products createProduct(String title, String description, String category, String price, String image) {

        FakeStoreProductDTO requestBody =
                FakeStoreProductDTO.builder()
                    .title(title)
                    .description(description)
                    .category(category)
                    .price(price)
                    .image(image)
                .build();

        FakeStoreProductDTO fakeStoreProductResponse = restTemplate.
                postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreProductDTO.class);

        if(Objects.nonNull(fakeStoreProductResponse)){
            return productMapper.mapToProduct(fakeStoreProductResponse);
        }

        return null;

    }


    @Override
    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        FakeStoreProductDTO[] dtos = responseEntity.getBody();

        if (dtos == null || dtos.length == 0) {
            System.out.println("Something went wrong..");
            return new ArrayList<>();
        }
        // create products
        for (FakeStoreProductDTO dto : dtos) {
            Products product = productMapper.mapToProduct(dto);
            products.add(product);
        }

        return products;
    }
}
