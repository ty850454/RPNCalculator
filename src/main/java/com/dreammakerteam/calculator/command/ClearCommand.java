package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStack;

/**
 * 清空命令处理器
 * 清空后无法撤销
 * @author xy
 */
public class ClearCommand implements CalcCommand {
    @Override
    public void execute(String command, CalcStack calcStack) {
        calcStack.clear();
    }

    @Override
    public String getCommand() {
        return "clear";
    }
}
