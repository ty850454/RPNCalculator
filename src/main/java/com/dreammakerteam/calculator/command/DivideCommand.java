package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 除法命令处理器
 * @author xy
 */
public class DivideCommand extends AbstractTwoOperandCommand {
    @Override
    BigDecimal getValue(CalcStackItem param1, CalcStackItem param2) {
        return param1.getValue().divide(param2.getValue(), 15, RoundingMode.HALF_UP);
    }

    @Override
    public String getCommand() {
        return "/";
    }
}
