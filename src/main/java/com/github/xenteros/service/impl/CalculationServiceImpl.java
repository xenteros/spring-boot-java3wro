package com.github.xenteros.service.impl;

import com.github.xenteros.service.CalculationService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by agurgul on 20.09.2017.
 */
@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public BigInteger factorial(Long n) {
        return factorial(BigInteger.valueOf(n));
    }

    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }
}
