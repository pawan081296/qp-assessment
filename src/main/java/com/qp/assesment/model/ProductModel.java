package com.qp.assesment.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductModel {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters !!")
    private String name;

    @NotNull
    @DecimalMin(value = "0.0", message = "Please enter valid amount")
    private Double price;

    @NotNull
    @Min(value = 1, message = "Quantity should be greater than or equal to one")
    private Integer quantity;

}
