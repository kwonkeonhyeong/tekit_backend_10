package org.example.restexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;
import org.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        long id = counter.incrementAndGet();
        product.setId(id);
        products.put(id,product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return products.get(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        products.put(id,product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        products.remove(id);
    }

}
