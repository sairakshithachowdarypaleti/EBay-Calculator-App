package com.ebay.rakshitha.calculator.strategy.impl;

import com.ebay.rakshitha.calculator.model.Operation;
import com.ebay.rakshitha.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class SubOperationImpl implements OperationStrategy {
    public Operation getOperationType() {
        return Operation.SUBTRACT;
    }

    public double apply(double a, double b) {
        return a - b;
    }
}
