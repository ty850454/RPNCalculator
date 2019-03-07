package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 操作一个数字的命令处理器
 * @author xy
 */
abstract class AbstractOneOperandCommand extends AbstractCommand {

    /**
     * 获取计算结果
     * @param param 被操作的数字
     * @return 计算结果
     */
    abstract BigDecimal getValue(CalcStackItem param);


    @Override
    BigDecimal getValue(CalcStackItem[] params) {
        return getValue(params[0]);
    }

    @Override
    int getOperand() {
        // 这里表示只需要一个数字
        return 1;
    }
}
