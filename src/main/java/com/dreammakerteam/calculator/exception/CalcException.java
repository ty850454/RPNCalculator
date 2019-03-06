package com.dreammakerteam.calculator.exception;

public class CalcException extends RuntimeException {
    private String operator;

    public CalcException(String operator, String message) {
        super(message);
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
