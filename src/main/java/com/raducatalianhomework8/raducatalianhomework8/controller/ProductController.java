package com.raducatalianhomework8.raducatalianhomework8.controller;

import com.raducatalianhomework8.raducatalianhomework8.model.Product;
import com.raducatalianhomework8.raducatalianhomework8.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/remaining")
    public List<Product> getRemainingProducts(){
        return productService.getRemainingProducts();
    }

    @PostMapping("/add")
    public Product insert(@RequestBody Product product){
        return productService.insert(product);
    }

    @PutMapping("/delete/{code}")
    public void delete(@PathVariable Integer code){
        productService.deleteProductByCode(code);
    }

    @PutMapping("/update/{code}")
    public void update(@PathVariable Integer code,@RequestParam Integer stock){
        productService.update(code, stock);
    }

    @PutMapping("/increment/{code}")
    public void increment(@PathVariable Integer code){
        productService.increment(code);
    }

    @PutMapping("/decrement/{code}")
    public void decrement(@PathVariable Integer code){
        productService.decrement(code);
    }
}
