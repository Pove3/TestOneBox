package com.test.imp.backend.services;

import com.test.imp.backend.model.Cart;
import com.test.imp.backend.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class CartService {
    private final Map<UUID, Cart> carts = new HashMap<>();

    //Genera un nuevo carrito
    public UUID createCart() {
        UUID cartId = generateCartId();
        Cart cart = new Cart(cartId);
        carts.put(cartId, cart);
        return cartId;
    }

    //Obtener carrito
    public Cart getCart(UUID cartId) {
        return carts.get(cartId);
    }

    //Agregar producto a un carrito por ID
    public void addProductToCart(UUID cartId, Product product) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.addProduct(product);
        }
    }

    //Borrar carrito mediante ID
    public void removeCart(UUID cartId) {
        carts.remove(cartId);
    }

    //Generador de ID para carrito
    private UUID generateCartId() {
        return UUID.randomUUID();
    }

    //Metodo que se ejecuta para borrar carritos con vida de mas de 10 minutos.
    @Scheduled(fixedRate = 60000)
    public void cleanExpiredCarts() {
        long currentTime = System.currentTimeMillis();
        carts.entrySet().removeIf(entry -> {
            long cartCreationTime = entry.getValue().getCreationTime();
            long elapsedTime = currentTime - cartCreationTime;
            return TimeUnit.MILLISECONDS.toMinutes(elapsedTime) >= 10;
        });
    }
}
