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

    // owner king
    @PostMapping
    @RequestMapping("/add/product")
    // @PreAuthorize("hasRole('king')")
    public static Mono<Product> addProductDetails(@RequestBody Product product) {
        return ProductService.addProductDetails(product);
    }

    // manager scott, owner
    @PutMapping
    @RequestMapping("/update/products")
    // @PreAuthorize("hasRole('manager')")
    public static Flux<Product> updateProductPrice() {
        return ProductService.getAllProductDetails();
    }
}