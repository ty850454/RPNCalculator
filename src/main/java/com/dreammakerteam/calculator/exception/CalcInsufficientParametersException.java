package com.dreammakerteam.calculator.exception;

/**
 * 参数不足
 * @author xy
 */
public class CalcInsufficientParametersException extends CalcException {

    public CalcInsufficientParametersException() {
        super("insufficient parameters");
    }
}
