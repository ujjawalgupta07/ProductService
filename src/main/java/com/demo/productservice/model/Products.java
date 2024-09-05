package com.demo.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Products extends BaseModel implements Serializable {

    private String title;
    private String description;
    private Float price;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
}
