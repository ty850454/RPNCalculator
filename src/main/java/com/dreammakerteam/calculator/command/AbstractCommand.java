package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcTypeEnum;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 操作数字的命令处理器
 * @author xy
 */
abstract class AbstractCommand implements CalcCommand {

    /**
     * 获取计算结果
     * @param params 被计算的数字
     * @return 计算结果
     */
    abstract BigDecimal getValue(CalcStackItem[] params);

    /**
     * 获取此计算命令需要的数字数量
     * @return 数字数量
     */
    abstract int getOperand();

    @Override
    public void execute(String command, CalcStack calcStack) {
        // 获取指定数量的被计算数
        CalcStackItem[] params = calcStack.getLastByNumber(getOperand());

        CalcStackItem item = new CalcStackItem();
        item.setType(CalcTypeEnum.OPERATION);
        // 设置计算结果
        item.setValue(getValue(params));
        // 重引用设置为第一个数的前一个
        item.setReRef(calcStack.getPrevItem(params[0]));
        // 压入栈中
        calcStack.push(item);
    }





}
