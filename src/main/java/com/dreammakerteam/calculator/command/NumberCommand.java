package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcTypeEnum;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;

/**
 * 数字命令处理器
 * 这是个特殊的命令，没有任何操作，只是将数字压入栈中
 * @author xy
 */
public class NumberCommand implements CalcCommand {
    @Override
    public void execute(String command, CalcStack calcStack) {
        BigDecimal number = new BigDecimal(command);
        CalcStackItem item = new CalcStackItem();
        item.setType(CalcTypeEnum.NUMBER);
        item.setValue(number);
        calcStack.push(item);
    }

    @Override
    public boolean choose(String command) {
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
