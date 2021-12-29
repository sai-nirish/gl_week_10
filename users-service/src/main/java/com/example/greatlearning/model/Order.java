package com.example.greatlearning.model;

import io.swagger.models.auth.In;
import lombok.*;

@Data
public class Order {
    Integer itemId;
    Integer quantity;
}
