package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 撤销命令处理器
 * @author xy
 */
public class UndoCommand implements CalcCommand {
    @Override
    public void execute(String command, CalcStack calcStack) {
        calcStack.undo();
    }

    @Override
    public String getCommand() {
        return "undo";
    }


}
