package com.ebay.rakshitha.calculator.strategy.impl;

import com.ebay.rakshitha.calculator.model.Operation;
import com.ebay.rakshitha.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class AddOperationImpl implements OperationStrategy {
    public Operation getOperationType() {
        return Operation.ADD;
    }

    public double apply(double a, double b) {
        return a + b;
    }
}
