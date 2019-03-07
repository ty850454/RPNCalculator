package com.dreammakerteam.calculator.stack;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 堆栈格式化
 * @author xy
 */
public class CalcStackFormat {

    private DecimalFormat df = new DecimalFormat();
    private CalcStack calcStack;


    public CalcStackFormat(CalcStack calcStack, String applyPattern) {
        df.applyPattern(applyPattern);
        this.calcStack = calcStack;
    }

    public String format() {
        LinkedList<String> result = new LinkedList<>();
        for (CalcStackItem lastNumber = calcStack.getLast(); lastNumber != null;) {
            result.push(df.format(lastNumber.getValue()));
            if (lastNumber.getType().equals(CalcTypeEnum.NUMBER)) {
                lastNumber = lastNumber.getPrev();
            } else {
                lastNumber = lastNumber.getReRef();
            }
        }
        return result.stream().collect(Collectors.joining(" "));
    }


}
