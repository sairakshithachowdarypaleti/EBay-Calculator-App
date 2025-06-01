package com.ebay.rakshitha.calculator.service.impl;

import com.ebay.rakshitha.calculator.dto.ChainedOperationRequest;
import com.ebay.rakshitha.calculator.exception.CalculatorException;
import com.ebay.rakshitha.calculator.helper.HistoryBuilder;
import com.ebay.rakshitha.calculator.model.CalculatorHistory;
import com.ebay.rakshitha.calculator.model.Operation;
import com.ebay.rakshitha.calculator.repository.CalculationHistoryRepository;
import com.ebay.rakshitha.calculator.service.CalculatorService;
import com.ebay.rakshitha.calculator.strategy.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final Map<Operation, OperationStrategy> strategyMap;

    private final CalculationHistoryRepository repo;

    @Autowired
    public CalculatorServiceImpl(List<OperationStrategy> strategies,
                                 CalculationHistoryRepository repo) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(OperationStrategy::getOperationType,
                        s -> s));
        this.repo = repo;
    }

    public double calculate(Operation operation, double a, double b) {
        OperationStrategy strategy = strategyMap.get(operation);
        if (strategy == null) throw new CalculatorException("Unsupported operation: " + operation);
        double result = strategy.apply(a, b);
        repo.save(HistoryBuilder.build(operation, a, b, result));
        return result;
    }

    public double chainCalculate(double initialValue, List<ChainedOperationRequest.OperationStep> steps) {
        double result = initialValue;
        for (ChainedOperationRequest.OperationStep step : steps) {
            OperationStrategy strategy = strategyMap.get(step.getOperation());

            if (strategy == null) throw new CalculatorException("Unsupported operation: " + step.getOperation());
            double prev = result;
            result = strategy.apply(result, step.getValue());
            repo.save(HistoryBuilder.build(step.getOperation(), prev, step.getValue(), result));
        }
        return result;
    }

    public List<CalculatorHistory> getAllHistory() {
        return repo.findAll();
    }
}
