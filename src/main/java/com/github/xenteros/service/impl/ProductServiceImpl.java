package com.github.xenteros.service.impl;

import com.github.xenteros.model.Product;
import com.github.xenteros.repository.ProductRepository;
import com.github.xenteros.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agurgul on 22.09.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
