package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

public class AdditionCommand extends AbstractTwoDigitOperationCommand {
    @Override
    BigDecimal getValue(CalcStackItem param1, CalcStackItem param2) {
        return param1.getValue().add(param2.getValue());
    }

    @Override
    public String getCommand() {
        return "+";
    }
}
