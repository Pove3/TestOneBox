package com.test.imp.backend.model;

import lombok.Data;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Cart {
    private final UUID cartId;
    private final Map<Integer, Product> products = new HashMap<>();
    private Instant creationTime;

    //Constructor
    public Cart(UUID cartId) {
        this.cartId = cartId;
        this.creationTime = Instant.now();
    }
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public long getCreationTime() {
        return creationTime.toEpochMilli();
    }
}
