package com.dreammakerteam.calculator;

import com.dreammakerteam.calculator.command.*;
import com.dreammakerteam.calculator.exception.CalcException;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackFormat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 计算器，控制输入输入以及调用命令解释器
 * @author xy
 */
public class Calculator {

    /** 命令解释器 */
    private final CommandInterpreter commandInterpreter;

    private Calculator(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    /**
     * 启动
     */
    public static void start() {
        // 默认命令
        List<CalcCommand> CalcCommands = Arrays.asList(
                new NumberCommand(),
                new AddCommand(),
                new SubtractCommand(),
                new MultiplyCommand(),
                new DivideCommand(),
                new SqrtCommand(),
                new ClearCommand(),
                new UndoCommand());
        // 新建实例并开始接收命令
        CalcStack stack = new CalcStack();
        CalcStackFormat calcStackFormat = new CalcStackFormat(stack, "0.##########");
        Calculator calculator = new Calculator(new CommandInterpreter(stack,CalcCommands, calcStackFormat));
        calculator.acceptCommand();
    }

    /**
     * 循环接收命令
     */
    private void acceptCommand() {
        for (String str = null; !"quit".equals(str);) {
            try {
                commandInterpreter.parseCommand(str = input());
            } catch (CalcException e) {
                output(e.getMessage());
            }
            output("stack: " + commandInterpreter.getStackFormat());
        }
    }

    private String input() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private void output(Object msg) {
        System.out.println(msg);
    }



}
