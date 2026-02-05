package com.sample.itemApi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Item {

    //id is generated on server side for preventing user manipulation
    
    private Long id;

    @Size(max = 100, min = 2)
    private String name;
    
    @NotBlank(message = "description can't be null")
    private String description;

    @NotNull(message = "Price is required !!")
    @Positive(message = "price must be a positive value")
    private Double price;

    @NotNull(message = "stock quantity can't be null")
    @Min(0)
    @NotBlank(message = "sock can't be blank")
    private Integer stockQuantity;
    
}
