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
    // @NotBlank(message = "id cannot be null")
    private Long id;

    @Size(max = 100, min = 2)
    private String name;
    
    @NotBlank(message = "description can not be null")
    private String description;

    @NotNull(message = "Price is a required !!")
    @Positive(message = "price must be a positive value")
    private double price;

    @NotNull(message = "stock quantity can not be null")
    @Min(0)
    private Integer stockQuantity;
    
}
