package com.dreammakerteam.calculator.exception;

/**
 * 无此命令
 * @author xy
 */
public class CalcUnknownCommandException extends CalcException {

    public CalcUnknownCommandException() {
        super("command not found");
    }
}
