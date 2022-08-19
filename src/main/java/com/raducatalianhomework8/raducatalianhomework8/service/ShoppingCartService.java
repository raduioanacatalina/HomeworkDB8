package com.raducatalianhomework8.raducatalianhomework8.service;

import com.raducatalianhomework8.raducatalianhomework8.model.Product;
import com.raducatalianhomework8.raducatalianhomework8.model.ShoppingCart;
import com.raducatalianhomework8.raducatalianhomework8.repository.ProductRepository;
import com.raducatalianhomework8.raducatalianhomework8.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public void addProduct(Integer productCode, Integer shoppingCartId) {
        Optional<Product> product = productRepository.findByCode(productCode);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().addProduct(product.get());
    }

    public void removeProduct(Integer productCode, Integer shoppingCartId) {
        Optional<Product> product = productRepository.findByCode(productCode);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        shoppingCart.get().removeProduct(product.get());
    }

    public Integer totalPrice(Integer shoppingCartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        return shoppingCart.get().totalPrice();
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart sc = new ShoppingCart();
        return shoppingCartRepository.save(sc);
    }

    public List<ShoppingCart> getAll(){
        return shoppingCartRepository.findAll();
    }
}
