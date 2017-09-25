package com.github.xenteros.service.impl;

import com.github.xenteros.model.User;
import com.github.xenteros.repository.UserRepository;
import com.github.xenteros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by agurgul on 25.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {

        if (user.getId() == null) {
            return userRepository.save(user);
        }
        return null;
    }
}
