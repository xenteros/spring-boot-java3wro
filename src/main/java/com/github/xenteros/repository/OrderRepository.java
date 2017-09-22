package com.github.xenteros.repository;

import com.github.xenteros.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by agurgul on 22.09.2017.
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
