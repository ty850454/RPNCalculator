package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 加法命令处理器
 * 需要两个数字
 * @author xy
 */
public class AddCommand extends AbstractTwoOperandCommand {
    @Override
    BigDecimal getValue(CalcStackItem param1, CalcStackItem param2) {
        // 直接相加
        return param1.getValue().add(param2.getValue());
    }

    @Override
    public String getCommand() {
        return "+";
    }
}
