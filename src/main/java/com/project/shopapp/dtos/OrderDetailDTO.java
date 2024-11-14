package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @NotNull(message = "Order ID is required")
    private Long orderId;

    @JsonProperty("product_id")
    @NotNull(message = "Product ID is required")
    private Long productId;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

    @Min(value = 0, message = "Price must be greater than 0")
    private Float price;

    @Min(value = 0, message = "Total must be greater than 0")
    private Float total;

    private String color;
}
