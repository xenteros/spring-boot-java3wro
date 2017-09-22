package com.github.xenteros.service;

import com.github.xenteros.model.Product;

import java.util.List;

/**
 * Created by agurgul on 22.09.2017.
 */
public interface ProductService {

    List<Product> findAll();
    Product findOne(Long id);
    Product create(Product product);
}
