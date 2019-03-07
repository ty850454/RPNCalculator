package com.dreammakerteam.calculator.stack;


import com.dreammakerteam.calculator.exception.CalcInsufficientParametersException;

/**
 * 指令堆栈
 * @author xy
 */
public class CalcStack {
    /** 最有一个 */
    private CalcStackItem last = null;

    /**
     * 压栈
     * @param item 栈命令
     */
    public void push(CalcStackItem item) {
        CalcStackItem l = last;
        last = item;
        if (l != null) {
            l.setNext(item);
            item.setPrev(l);
        }
    }

    /**
     * 获取最后一个命令
     * @return 栈命令
     */
    public CalcStackItem getLast() {
        return last;
    }

    /**
     * 清空栈
     */
    public void clear() {
        for (CalcStackItem lastNumber = last; lastNumber != null;) {

            CalcStackItem prev = lastNumber.getPrev();
            lastNumber.setNext(null);
            lastNumber.setReRef(null);
            lastNumber.setPrev(null);

            lastNumber = prev;
        }
        last = null;
    }

    /**
     * 撤销最后一个栈命令
     */
    public void undo() {
        CalcStackItem lastNumber = last;

        if (lastNumber == null) {
            return;
        }
        CalcStackItem prev = lastNumber.getPrev();
        last = prev;
        lastNumber.setNext(null);
        lastNumber.setReRef(null);
        lastNumber.setPrev(null);
        if (prev != null) {
            prev.setNext(null);
        }
    }

    /**
     * 获取指定栈命令前面一个栈命令
     * 如果当前栈命令是数字，则取实际位置前一个
     * 如果当前栈命令是操作，则取前面一个没经过计算的数字栈命令或者已经计算过的操作栈命令
     * @param item 栈命令
     * @return 栈命令
     */
    public CalcStackItem getPrevItem(CalcStackItem item) {
        if (item.getType().equals(CalcTypeEnum.NUMBER)) {
            return item.getPrev();
        } else {
            return item.getReRef();
        }
    }

    /**
     * 从后向前获取指定数量的栈命令
     * @param num 获取几个
     * @return 栈命令数组
     */
    public CalcStackItem[] getLastByNumber(int num) {
        CalcStackItem last = this.last;
        CalcStackItem[] result = new CalcStackItem[num];

        for (int i = num - 1; i >= 0; --i) {
            if (last == null) {
                throw new CalcInsufficientParametersException();
            }
            result[i] = last;
            last = getPrevItem(last);
        }
        return result;
    }
}
