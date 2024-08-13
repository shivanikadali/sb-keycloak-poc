package com.example.sb_keycloak_poc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private static List<Product> products = new ArrayList<>();

    @PostConstruct
    public static void init() {
        Product prod1 = new Product("Dell", "LP101",
                "Dell [Smartchoice] 15 Thin & Light Laptop, 12th Gen Intel Core i3-1215U Processor/8GB", "35000");
        Product prod2 = new Product("Lenovo", "LP102", "Lenovo IdeaPad Slim 1 Intel Core Celeron N4020 14", "26000");
        products.add(prod1);
        products.add(prod2);
    }

    public static Flux<Product> getAllProductDetails() {
        return Flux.fromIterable(products);
    }

    public static Mono<Product> addProductDetails(Product product) {
        products.add(product);
        return Mono.just(product);
    }
}
