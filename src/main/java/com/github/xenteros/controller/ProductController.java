package com.github.xenteros.controller;

import com.github.xenteros.model.Product;
import com.github.xenteros.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by agurgul on 22.09.2017.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOneById(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @PutMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

}
