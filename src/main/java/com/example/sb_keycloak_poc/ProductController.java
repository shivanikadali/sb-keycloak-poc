package com.example.sb_keycloak_poc;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping
    @RequestMapping("/get/products")
    public static List<Product> getAllProductDetails() {
        return ProductService.getAllProductDetails();
    }

    // owner king
    @PostMapping
    @RequestMapping("/add/product")
    public static Product addProductDetails(@RequestBody Product product) {
        return ProductService.addProductDetails(product);
    }

    // manager scott, owner
    @PutMapping
    @RequestMapping("/update/products")
    public static List<Product> updateProductPrice() {
        return ProductService.getAllProductDetails();
    }

    @GetMapping("/authenticated")
    public String name() {
        return "authenticated";
    }
}