package com.dreammakerteam.calculator.stack;


import com.dreammakerteam.calculator.CalcTypeEnum;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 指令堆栈
 * @author xy
 */
public class CalcStack {

    private CalcStackItem last = null;
    private static final DecimalFormat DF = new DecimalFormat();
    static {
        DF.applyPattern("0.##########");
    }

    public void push(CalcStackItem item) {
        CalcStackItem l = last;
        last = item;
        if (l != null) {
            l.setNext(item);
            item.setPrev(l);
        }
    }

    public CalcStackItem getLast() {
        return last;
    }


    @Override
    public String toString() {
        LinkedList<String> result = new LinkedList<>();
        for (CalcStackItem lastNumber = last; lastNumber != null;) {

            DecimalFormat df = new DecimalFormat();

            result.push(df.format(lastNumber.getValue()));
            if (lastNumber.getType().equals(CalcTypeEnum.NUMBER)) {
                lastNumber = lastNumber.getPrev();
            } else {
                lastNumber = lastNumber.getReRef();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(' ');
        }

        return sb.toString();
    }

    public void clear() {
        for (CalcStackItem lastNumber = last; lastNumber != null;) {

            CalcStackItem prev = lastNumber.getPrev();
            lastNumber.setNext(null);
            lastNumber.setReRef(null);
            lastNumber.setPrev(null);

            lastNumber = prev;
        }
        last = null;
    }
}
