package com.dreammakerteam.calculator;

import com.dreammakerteam.calculator.command.*;
import com.dreammakerteam.calculator.exception.CalcException;
import com.dreammakerteam.calculator.stack.CalcStack;
import com.dreammakerteam.calculator.stack.CalcStackFormat;
import com.dreammakerteam.calculator.stack.CalcStackItem;
import com.dreammakerteam.calculator.stack.CalcTypeEnum;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommandInterpreterTest {

    private CommandInterpreter commandInterpreter;
    @Before
    public void setUp() throws Exception {
        List<CalcCommand> CalcCommands = Arrays.asList(
                new NumberCommand(),
                new AddCommand(),
                new SubtractCommand(),
                new MultiplyCommand(),
                new DivideCommand(),
                new SqrtCommand(),
                new ClearCommand(),
                new UndoCommand());
        CalcStack stack = new CalcStack();
        CalcStackFormat calcStackFormat = new CalcStackFormat(stack, "0.##########");
        commandInterpreter = new CommandInterpreter(stack, CalcCommands, calcStackFormat);
    }

    @Test
    public void parseCommandWhenExamples1() {
        String result = commandInterpreter.parseCommand("5 2");
        assertEquals(result, "5 2");
    }

    @Test
    public void parseCommandWhenExamples2() {
        String result = commandInterpreter.parseCommand("2 sqrt");
        assertEquals(result, "1.4142135624");
        result = commandInterpreter.parseCommand("clear 9 sqrt");
        assertEquals(result, "3");
    }
    @Test
    public void parseCommandWhenExamples3() {
        String result = commandInterpreter.parseCommand("5 2 -");
        assertEquals(result, "3");
        result = commandInterpreter.parseCommand("3 -");
        assertEquals(result, "0");
        result = commandInterpreter.parseCommand("clear");
        assertEquals(result, "");
    }
    @Test
    public void parseCommandWhenExamples4() {
        String result = commandInterpreter.parseCommand("5 4 3 2");
        assertEquals(result, "5 4 3 2");
        result = commandInterpreter.parseCommand("undo undo *");
        assertEquals(result, "20");
        result = commandInterpreter.parseCommand("5 *");
        assertEquals(result, "100");
        result = commandInterpreter.parseCommand("undo");
        assertEquals(result, "20 5");
    }
    @Test
    public void parseCommandWhenExamples5() {
        String result = commandInterpreter.parseCommand("7 12 2 /");
        assertEquals(result, "7 6");
        result = commandInterpreter.parseCommand("*");
        assertEquals(result, "42");
        result = commandInterpreter.parseCommand("4 /");
        assertEquals(result, "10.5");
    }
    @Test
    public void parseCommandWhenExamples6() {
        String result = commandInterpreter.parseCommand("1 2 3 4 5");
        assertEquals(result, "1 2 3 4 5");
        result = commandInterpreter.parseCommand("*");
        assertEquals(result, "1 2 3 20");
        result = commandInterpreter.parseCommand("clear 3 4 -");
        assertEquals(result, "-1");
    }
    @Test
    public void parseCommandWhenExamples7() {
        String result = commandInterpreter.parseCommand("1 2 3 4 5");
        assertEquals(result, "1 2 3 4 5");
        result = commandInterpreter.parseCommand("* * * *");
        assertEquals(result, "120");
    }
    @Test
    public void parseCommandWhenExamples8() {
        try {
            commandInterpreter.parseCommand("1 2 3 * 5 + * * 6 5");
        } catch (CalcException e) {
            assertEquals(e.getMessage(), "operator * (position: 15): insufficient parameters");
        }
        String result = commandInterpreter.getStackFormat();
        assertEquals(result, "11");
    }





}