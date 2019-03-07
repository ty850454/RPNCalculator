package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 操作两个数字的命令处理器
 * @author xy
 */
abstract class AbstractTwoOperandCommand extends AbstractCommand {
    /**
     * 获取计算结果
     * @param param1 被操作的第一个数字
     * @param param2 被操作的第二个数字
     * @return 计算结果
     */
    abstract BigDecimal getValue(CalcStackItem param1, CalcStackItem param2);


    @Override
    BigDecimal getValue(CalcStackItem[] params) {
        return getValue(params[0], params[1]);
    }

    @Override
    int getOperand() {
        // 这里表示需要两个数字
        return 2;
    }
}
