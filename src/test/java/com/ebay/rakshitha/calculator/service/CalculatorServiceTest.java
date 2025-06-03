package com.ebay.rakshitha.calculator.service;

import com.ebay.rakshitha.calculator.CalculatorTestApplication;
import com.ebay.rakshitha.calculator.dto.ChainedOperationRequest;
import com.ebay.rakshitha.calculator.model.Operation;
import com.ebay.rakshitha.calculator.service.CalculatorService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = CalculatorTestApplication.class)
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testAddition() {
        double result = calculatorService.calculate(Operation.ADD, 10, 5);
        assertEquals(15.0, result);
    }

    @Test
    public void testSubtraction() {
        double result = calculatorService.calculate(Operation.SUBTRACT, 10, 5);
        assertEquals(5.0, result);
    }

    @Test
    public void testMultiplication() {
        double result = calculatorService.calculate(Operation.MULTIPLY, 10, 5);
        assertEquals(50.0, result);
    }

    @Test
    public void testDivide() {
        double result = calculatorService.calculate(Operation.DIVIDE, 10, 5);
        assertEquals(2.0, result);
    }

    @Test
    public void testChainedOperations() {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(5);

        ChainedOperationRequest.OperationStep step1 = new ChainedOperationRequest.OperationStep();
        step1.setOperation(Operation.ADD);
        step1.setValue(3);

        ChainedOperationRequest.OperationStep step2 = new ChainedOperationRequest.OperationStep();
        step2.setOperation(Operation.MULTIPLY);
        step2.setValue(2);

        ChainedOperationRequest.OperationStep step3 = new ChainedOperationRequest.OperationStep();
        step3.setOperation(Operation.SUBTRACT);
        step3.setValue(4);

        ChainedOperationRequest.OperationStep step4 = new ChainedOperationRequest.OperationStep();
        step4.setOperation(Operation.DIVIDE);
        step4.setValue(2);

        request.setOperationStepList(List.of(step1, step2, step3, step4));

        double result = calculatorService.chainCalculate(request.getInitialValue(), request.getOperationStepList());

        assertEquals(6.0, result);
    }

    @Test
    public void testDivisionByZeroThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
           calculatorService.calculate(Operation.DIVIDE, 10, 0);
        });

        assertEquals("Division by zero", exception.getMessage());
    }

}
