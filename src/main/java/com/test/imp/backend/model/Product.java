package com.test.imp.backend.model;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String description;
    private final int quantity;
}
