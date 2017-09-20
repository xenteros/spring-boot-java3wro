package com.github.xenteros.service.impl;

import com.github.xenteros.service.HelloWorldService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by agurgul on 20.09.2017.
 */
@Service
@Primary
//@Profile("reg")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String hello() {
        return "Hello World";
    }
}
