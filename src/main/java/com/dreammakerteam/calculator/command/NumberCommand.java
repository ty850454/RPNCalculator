package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.CalcTypeEnum;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

public class NumberCommand implements CalcCommand {
    @Override
    public void calc(String command, CalcStack calcStack) {
        BigDecimal number = new BigDecimal(command);
        CalcStackItem item = new CalcStackItem();
        item.setType(CalcTypeEnum.NUMBER);
        item.setValue(number);
        calcStack.push(item);
    }

    @Override
    public boolean canUse(String command) {
        for (char aChar : command.toCharArray()) {
            if (aChar < '0' || aChar > '9') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCommand() {
        return null;
    }
}
