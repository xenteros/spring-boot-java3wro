package com.github.xenteros.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by agurgul on 20.09.2017.
 */
@Service
public interface CalculationService {

    BigInteger factorial(Long n);

}
