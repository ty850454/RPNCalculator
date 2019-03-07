package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 减法命令处理器
 * @author xy
 */
public class SubtractCommand extends AbstractTwoOperandCommand {
    @Override
    BigDecimal getValue(CalcStackItem param1, CalcStackItem param2) {
        return param1.getValue().subtract(param2.getValue());
    }

    @Override
    public String getCommand() {
        return "-";
    }
}
