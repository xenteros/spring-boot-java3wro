package com.github.xenteros.service.impl;

import com.github.xenteros.model.Order;
import com.github.xenteros.model.Product;
import com.github.xenteros.repository.OrderRepository;
import com.github.xenteros.repository.ProductRepository;
import com.github.xenteros.service.OrderService;
import com.github.xenteros.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by agurgul on 22.09.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order create(List<Long> productIds) {
        Set<Product> products = productRepository.findByIdIn(productIds);
        Order order = new Order();
        order.setProducts(products);
        order.setTotalPrice(products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return orderRepository.save(order);
    }
}
