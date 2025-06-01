package com.ebay.rakshitha.calculator.service;

import com.ebay.rakshitha.calculator.dto.ChainedOperationRequest;
import com.ebay.rakshitha.calculator.model.CalculatorHistory;
import com.ebay.rakshitha.calculator.model.Operation;

import java.util.List;

public interface CalculatorService {
    double calculate(Operation operation, double a, double b);
    double chainCalculate(double initialValue,
                          List<ChainedOperationRequest.OperationStep> steps);
    List<CalculatorHistory> getAllHistory();
}
