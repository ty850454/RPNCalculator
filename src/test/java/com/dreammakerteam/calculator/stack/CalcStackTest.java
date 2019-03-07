package com.dreammakerteam.calculator.stack;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalcStackTest {
    private CalcStack calcStack = new CalcStack();
    @Before
    public void setUp() throws Exception {


        CalcStackItem item1 = new CalcStackItem();
        item1.setType(CalcTypeEnum.NUMBER);
        item1.setValue(BigDecimal.valueOf(1));
        calcStack.push(item1);

        CalcStackItem item2 = new CalcStackItem();
        item2.setType(CalcTypeEnum.NUMBER);
        item2.setValue(BigDecimal.valueOf(2));
        calcStack.push(item2);

        CalcStackItem item3 = new CalcStackItem();
        item3.setType(CalcTypeEnum.NUMBER);
        item3.setValue(BigDecimal.valueOf(3));
        calcStack.push(item3);



    }

    @Test
    public void getLastByNumberWhenNumberIs1() {
        CalcStackItem[] lastByNumber = calcStack.getLastByNumber(1);
        assertEquals(lastByNumber.length, 1);
        assertNotNull(lastByNumber[0]);
        assertEquals(0, lastByNumber[0].getValue().compareTo(BigDecimal.valueOf(3)));
    }

    @Test
    public void getLastByNumberWhenNumberIs3() {
        CalcStackItem[] lastByNumber = calcStack.getLastByNumber(3);
        assertEquals(lastByNumber.length, 3);
        assertNotNull(lastByNumber[0]);
        assertEquals(0, lastByNumber[0].getValue().compareTo(BigDecimal.valueOf(1)));
        assertNotNull(lastByNumber[1]);
        assertEquals(0, lastByNumber[1].getValue().compareTo(BigDecimal.valueOf(2)));
        assertNotNull(lastByNumber[2]);
        assertEquals(0, lastByNumber[2].getValue().compareTo(BigDecimal.valueOf(3)));
    }
}