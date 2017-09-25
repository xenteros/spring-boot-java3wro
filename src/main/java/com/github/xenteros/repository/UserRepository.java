package com.github.xenteros.repository;

import com.github.xenteros.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by agurgul on 25.09.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
