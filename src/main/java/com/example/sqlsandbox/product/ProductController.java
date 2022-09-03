package com.example.sqlsandbox.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produkt")
public class ProductController {

    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping("/getproduct")
    public ResponseEntity<List<ProductItem>> getProduct() {
        List<ProductItem> list = productItemRepository.findAll();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductItem> postProduct(@RequestBody ProductItem pi) {
        ProductItem savedItem = productItemRepository.save(pi);

        return ResponseEntity.ok(savedItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletProduct(@PathVariable("id") String id) {
        Optional<ProductItem> itemToDelete = productItemRepository.findById(id);
        String idToDelete = itemToDelete.get().getId();
        String nameToDelete = itemToDelete.get().getName();
        itemToDelete.ifPresent(productItem -> productItemRepository.delete(productItem));

        return ResponseEntity.ok("Produkt: " + nameToDelete + ", mit id: " + idToDelete + ", wurde gelöscht.");
    }
}
