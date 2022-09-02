package com.example.sqlsandbox.controller;

import com.example.sqlsandbox.model.ProductItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.ReadPendingException;

@RestController("/product")
public class ProductController {


    @GetMapping("/getp")
    public ResponseEntity<ProductItem> getProduct() {
        ProductItem p = ProductItem.builder().name("Neues Produkt").build();

        return ResponseEntity.ok(p);
    }
}
