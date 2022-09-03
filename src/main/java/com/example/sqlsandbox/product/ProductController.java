package com.example.sqlsandbox.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produkt")
public class ProductController {

    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping("/getproduct")
    public ResponseEntity<List<ProductItem>> getProduct() {
        List<ProductItem> list = productItemRepository.findAll();
        //list.add(ProductItem.builder().name("Produktname").build());

        return ResponseEntity.ok(list);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductItem> postProduct(@RequestBody ProductItem pi) {
        ProductItem savedItem = productItemRepository.save(pi);

        return ResponseEntity.ok(savedItem);
    }
}
