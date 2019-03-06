package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

public class SubtractionCommand extends AbstractTwoDigitOperationCommand {
    @Override
    BigDecimal getValue(CalcStackItem param1, CalcStackItem param2) {
        return param1.getValue().subtract(param2.getValue());
    }

    @Override
    public String getCommand() {
        return "-";
    }
}
