package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStack;

public class ClearCommand implements CalcCommand {
    @Override
    public void calc(String command, CalcStack calcStack) {
        calcStack.clear();
    }

    @Override
    public String getCommand() {
        return "clear";
    }
}
