package com.raducatalianhomework8.raducatalianhomework8.controller;

import com.raducatalianhomework8.raducatalianhomework8.model.ShoppingCart;
import com.raducatalianhomework8.raducatalianhomework8.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("add/{productCode}/{shoppingCartId}")
    public void addProduct(@PathVariable Integer productCode, @PathVariable Integer shoppingCartId) {
        shoppingCartService.addProduct(productCode, shoppingCartId);
    }

    @DeleteMapping("remove/{productCode}/{shoppingCartId}")
    public void deleteProduct(@PathVariable Integer productCode, @PathVariable Integer shoppingCartId) {
        shoppingCartService.removeProduct(productCode, shoppingCartId);
    }

    @GetMapping("price/{shoppingCartId}")
    public Integer totalPrice(@PathVariable Integer shoppingCartId) {
        return shoppingCartService.totalPrice(shoppingCartId);
    }

    @PostMapping
    public ShoppingCart createShoppingCart() {
        return shoppingCartService.createShoppingCart();
    }

    @GetMapping("/all")
    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartService.getAll();
    }
}
