package com.github.xenteros.service;

import com.github.xenteros.model.Order;

import java.util.List;

/**
 * Created by agurgul on 22.09.2017.
 */
public interface OrderService {
    List<Order> findAll();
    Order findById(Long id);
    Order create(List<Long> productIds);
}
