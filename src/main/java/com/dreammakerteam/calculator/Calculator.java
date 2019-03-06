package com.dreammakerteam.calculator;

import com.dreammakerteam.calculator.command.*;
import com.dreammakerteam.calculator.exception.CalcException;
import com.dreammakerteam.calculator.exception.CalcUnknownCommandException;
import com.dreammakerteam.calculator.stack.CalcStack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 计算器
 * @author xy
 */
public class Calculator {

    private CalcStack stack = new CalcStack();
    private final List<CalcCommand> calcStrategies;


    public Calculator(List<CalcCommand> calcStrategies) {
        this.calcStrategies = calcStrategies;
    }

    public static void start() {
        List<CalcCommand> calcStrategies = Arrays.asList(
                new NumberCommand(),
                new AdditionCommand(),
                new SubtractionCommand(),
                new MultiplicationCommand(),
                new DivisionCommand(),
                new ClearCommand());
        Calculator calculator = new Calculator(calcStrategies);
        calculator.run();



    }

    public void run() {
        for (String str = null; !"quit".equals(str);) {
            output("stack：" + stack.toString());
            output("请输入：");
            commandProcessing(str = input());
        }
    }


    private String input() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private void output(Object msg) {
        System.out.println(msg);
    }


    private void commandProcessing(String commandStr) {
        char[] chars = commandStr.toCharArray();
        StringBuilder command = new StringBuilder();

        int i = 1;
        try {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    parseCommand(command);
                    continue;
                }
                command.append(aChar);
                ++i;
            }
            parseCommand(command);
        } catch (CalcException e) {
            output("operator " + command + " (position: " + (i - command.length()) + "): " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            output("未知异常：" + i);
        }
    }

    private void parseCommand(StringBuilder command) {
        if (command.length() > 0) {
            calc(command.toString());
            command.setLength(0);
        }
    }

    private void calc(String command) {
        CalcCommand calcCommand = getCalcStrategy(command);
        if (calcCommand == null) {
            throw new CalcUnknownCommandException(command);
        }
        calcCommand.calc(command, stack);
    }

    private CalcCommand getCalcStrategy(String command) {
        for (CalcCommand calcCommand : calcStrategies) {
            if (calcCommand.canUse(command)) {
                return calcCommand;
            }
        }
        return null;
    }
}
