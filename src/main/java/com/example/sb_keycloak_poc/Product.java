package com.example.sb_keycloak_poc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private String prodName;
    private String productId;
    private String Description;
    private String price;

}
