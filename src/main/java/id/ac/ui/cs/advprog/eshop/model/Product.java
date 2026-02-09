package id.ac.ui.cs.advprog.eshop.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String productId;

    @NotBlank(message = "Product name cannot be empty")
    private String productName;

    @Min(value = 0, message = "Product quantity cannot be negative")
    private int productQuantity;
}