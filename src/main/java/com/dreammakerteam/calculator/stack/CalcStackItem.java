package com.dreammakerteam.calculator.stack;

import com.dreammakerteam.calculator.CalcTypeEnum;

import java.math.BigDecimal;

/**
 * 指令堆栈中存放的对象
 * @author xy
 */
public class CalcStackItem {

    private CalcStackItem next;
    private CalcStackItem prev;
    private BigDecimal value;
    private CalcTypeEnum type;
    /** 重引用 非null代表上一个没有参与计算的item */
    private CalcStackItem reRef;


    public CalcStackItem getNext() {
        return next;
    }

    void setNext(CalcStackItem next) {
        this.next = next;
    }

    public CalcStackItem getPrev() {
        return prev;
    }

    void setPrev(CalcStackItem prev) {
        this.prev = prev;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CalcTypeEnum getType() {
        return type;
    }

    public void setType(CalcTypeEnum type) {
        this.type = type;
    }

    public CalcStackItem getReRef() {
        return reRef;
    }

    public void setReRef(CalcStackItem reRef) {
        this.reRef = reRef;
    }

}
