package com.ebay.rakshitha.calculator.strategy.impl;

import com.ebay.rakshitha.calculator.model.Operation;
import com.ebay.rakshitha.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class DivideOperationImpl implements OperationStrategy {
    public Operation getOperationType() {
        return Operation.DIVIDE;
    }

    public double apply(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
