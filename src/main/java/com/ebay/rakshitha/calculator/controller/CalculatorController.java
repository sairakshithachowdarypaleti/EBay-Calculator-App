package com.ebay.rakshitha.calculator.controller;

import com.ebay.rakshitha.calculator.dto.ChainedOperationRequest;
import com.ebay.rakshitha.calculator.dto.OperationRequest;
import com.ebay.rakshitha.calculator.model.CalculatorHistory;
import com.ebay.rakshitha.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @PostMapping
    public double calculate(@RequestBody OperationRequest request) {
        return service.calculate(request.getOperation(), request.getNumberOne(), request.getNumberTwo());
    }

    @PostMapping("/chain")
    public double calculateChained(@RequestBody ChainedOperationRequest request) {
        return service.chainCalculate(request.getInitialValue(), request.getOperationStepList());
    }

    @GetMapping("/history")
    public List<CalculatorHistory> getHistory() {
        return service.getAllHistory();
    }

}
