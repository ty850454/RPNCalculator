package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.CalcTypeEnum;
import com.dreammakerteam.calculator.exception.CalcInsufficientParametersException;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

public abstract class AbstractTwoDigitOperationCommand implements CalcCommand {


    abstract BigDecimal getValue(CalcStackItem param1, CalcStackItem param2);

    @Override
    public void calc(String command, CalcStack calcStack) {
        CalcStackItem param2 = calcStack.getLast();
        if (param2 == null) {
            throw new CalcInsufficientParametersException(command);
        }
        CalcStackItem param1;
        if (param2.getType().equals(CalcTypeEnum.NUMBER)) {
            param1 = param2.getPrev();
        } else {
            param1 = param2.getReRef();
        }
        if (param1 == null) {
            throw new CalcInsufficientParametersException(command);
        }

        CalcStackItem item = new CalcStackItem();
        item.setType(CalcTypeEnum.OPERATION);
        item.setValue(getValue(param1, param2));
        if (param1.getType().equals(CalcTypeEnum.NUMBER)) {
            item.setReRef(param1.getPrev());
        } else {
            item.setReRef(param1.getReRef());
        }

        calcStack.push(item);
    }


}
