package com.github.xenteros.repository;

import com.github.xenteros.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by agurgul on 22.09.2017.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findByIdIn(List<Long> ids);
}
