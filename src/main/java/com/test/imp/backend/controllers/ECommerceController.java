package com.test.imp.backend.controllers;

import com.test.imp.backend.model.Cart;
import com.test.imp.backend.model.Product;
import com.test.imp.backend.services.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@Api(tags = "ECommerce", description = "Operaciones relacionadas con el carrito de compras y productos")
public class ECommerceController {
    private final CartService cartService;

    public ECommerceController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/createCart")
    @ApiOperation(value = "Crear un nuevo carrito", notes = "Devuelve el ID del nuevo carrito")
    public UUID createCart() {
        return cartService.createCart();
    }

    @GetMapping("/getCart/{cartId}")
    @ApiOperation(value = "Obtener detalles de un carrito", notes = "Devuelve detalles del carrito según el ID proporcionado")
    @ApiParam(value = "ID del carrito", required = true)
    public Cart getCart(@PathVariable UUID cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping("/addProductToCart/{cartId}")
    @ApiOperation(value = "Agregar producto a un carrito", notes = "Añade un producto al carrito según el ID proporcionado")
    public void addProductToCart(
            @PathVariable UUID cartId,
            @RequestBody Product product) {
        cartService.addProductToCart(cartId, product);
    }

    @DeleteMapping("/removeCart/{cartId}")
    @ApiOperation(value = "Eliminar un carrito", notes = "Elimina el carrito según el ID proporcionado")
    @ApiParam(value = "ID del carrito", required = true)
    public void removeCart(@PathVariable UUID cartId) {
        cartService.removeCart(cartId);
    }
}