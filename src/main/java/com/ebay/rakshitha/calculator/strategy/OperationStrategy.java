package com.ebay.rakshitha.calculator.strategy;

import com.ebay.rakshitha.calculator.model.Operation;

public interface OperationStrategy {
    Operation getOperationType();
    double apply(double a, double b);
}
