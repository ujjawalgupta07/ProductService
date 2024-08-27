package com.demo.productservice.advise;

import com.demo.productservice.dto.response.ErrorDTO;
import com.demo.productservice.exception.InvalidProductIdException;
import com.demo.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception){
        ErrorDTO dto =
                ErrorDTO.builder()
                .code("product_not_found")
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDTO> handleInvalidProductIdException(InvalidProductIdException exception){
        ErrorDTO dto =
                ErrorDTO.builder()
                        .code("invalid_product_id")
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
