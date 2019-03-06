package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStack;

public interface CalcCommand {

    void calc(String command, CalcStack calcStack);

    default boolean canUse(String command) {
        return getCommand().equals(command);
    }

    String getCommand();

}
