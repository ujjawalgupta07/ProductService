package com.demo.productservice.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categories extends BaseModel implements Serializable {

    private String title;

}
