package com.example.sb_keycloak_poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @GetMapping
    @RequestMapping("/get/products")
    public static Flux<Product> getAllProductDetails() {
        return ProductService.getAllProductDetails();
    }

    // owner scott
    @PostMapping
    @RequestMapping("/add/product")
    public static Mono<Product> addProductDetails(@RequestBody Product product) {
        return ProductService.addProductDetails(product);
    }

    // manager blake, owner 
    @PutMapping
    @RequestMapping("/update/products")
    public static Flux<Product> updateProductPrice() {
        return ProductService.getAllProductDetails();
    }
}