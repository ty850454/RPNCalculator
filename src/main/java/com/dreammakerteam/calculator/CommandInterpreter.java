package com.dreammakerteam.calculator;

import com.dreammakerteam.calculator.command.CalcCommand;
import com.dreammakerteam.calculator.exception.CalcException;
import com.dreammakerteam.calculator.exception.CalcUnknownCommandException;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackFormat;

import java.util.List;

/**
 * 命令解释器，接收命令，选择合适的命令处理器执行，输出stack
 * @author xy
 */
public class CommandInterpreter {
    /** 命令堆栈 每次输入的命令压入此堆栈 */
    private CalcStack stack;
    /** 堆栈格式化 */
    private CalcStackFormat calcStackFormat;
    /** 命令处理器 */
    private List<CalcCommand> CalcCommands;

    public CommandInterpreter(CalcStack stack, List<CalcCommand> CalcCommands, CalcStackFormat calcStackFormat) {
        this.stack = stack;
        this.CalcCommands = CalcCommands;
        this.calcStackFormat = calcStackFormat;
    }

    /**
     * 获取格式化的栈堆
     * @return 栈堆
     */
    public String getStackFormat() {
        return calcStackFormat.format();
    }

    /**
     * 命令解析
     * @param commandStr 一行命令
     * @return stack
     */
    public String parseCommand(String commandStr) {
        char[] chars = commandStr.toCharArray();

        // 单个的命令文本
        StringBuilder command = new StringBuilder();

        // 字符索引
        int i = 0;
        try {
            for (char aChar : chars) {
                ++i;
                if (aChar == ' ') {
                    executeCommandBeforehand(command);
                    continue;
                }
                command.append(aChar);
            }
            executeCommandBeforehand(command);
        } catch (CalcException e) {
            throw new CalcException("operator " + command + " (position: " + (i - command.length()) + "): " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CalcException("未知异常");
        }
        return calcStackFormat.format();
    }

    /**
     * 预执行命令
     * @param command 命令
     */
    private void executeCommandBeforehand(StringBuilder command) {
        if (command.length() > 0) {
            // 执行
            executeCommand(command.toString());
            command.setLength(0);
        }
    }

    /**
     * 执行命令
     * @param command 命令
     */
    private void executeCommand(String command) {
        // 选择命令处理器
        CalcCommand calcCommand = chooseCalcCommands(command);
        if (calcCommand == null) {
            throw new CalcUnknownCommandException();
        }
        // 调用命令处理器处理命令
        calcCommand.execute(command, stack);
    }

    /**
     * 选择合适的命令处理器
     * @param command 命令
     * @return 命令处理器
     */
    private CalcCommand chooseCalcCommands(String command) {
        for (CalcCommand calcCommand : CalcCommands) {
            if (calcCommand.choose(command)) {
                return calcCommand;
            }
        }
        return null;
    }

}
