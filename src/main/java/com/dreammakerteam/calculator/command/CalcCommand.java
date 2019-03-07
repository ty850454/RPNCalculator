package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStack;

/**
 * 命令处理器接口
 * @author xy
 */
public interface CalcCommand {

    /**
     * 命令处理器开始执行
     * @param command 命令
     * @param stack 堆栈
     */
    void execute(String command, CalcStack stack);

    /**
     * 选择是否使用此命令处理器
     * @param command 命令
     * @return 适用于此命令处理器返回true，否则返回false
     */
    default boolean choose(String command) {
        return getCommand().equals(command);
    }

    /**
     * 命令符号
     * @return 命令符号
     */
    String getCommand();

}
