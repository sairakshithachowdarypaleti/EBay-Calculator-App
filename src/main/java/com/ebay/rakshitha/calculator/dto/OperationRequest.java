package com.ebay.rakshitha.calculator.dto;

import com.ebay.rakshitha.calculator.model.Operation;

public class OperationRequest {

    private Operation operation;
    private double numberOne;
    private double numberTwo;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }
}
