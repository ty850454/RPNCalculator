package com.dreammakerteam.calculator.exception;

public class CalcUnknownCommandException extends CalcException {
    public CalcUnknownCommandException(String command) {
        super(command, "command not found");
    }
}
