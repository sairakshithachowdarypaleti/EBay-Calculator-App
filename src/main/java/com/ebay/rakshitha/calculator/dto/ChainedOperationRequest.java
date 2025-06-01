package com.ebay.rakshitha.calculator.dto;

import com.ebay.rakshitha.calculator.model.Operation;

import java.util.List;

public class ChainedOperationRequest {

    private double initialValue;
    private List<OperationStep> operationStepList;

    public static class OperationStep {
        private Operation operation;
        private double value;

        public Operation getOperation() {
            return operation;
        }

        public void setOperation(Operation operation) {
            this.operation = operation;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public List<OperationStep> getOperationStepList() {
        return operationStepList;
    }

    public void setOperationStepList(List<OperationStep> operationStepList) {
        this.operationStepList = operationStepList;
    }
}
