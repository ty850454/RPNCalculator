package com.dreammakerteam.calculator.command;

import com.dreammakerteam.calculator.stack.CalcStackItem;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 求平方根命令处理器
 * 使用牛顿法
 * @author xy
 */
public class SqrtCommand extends AbstractOneOperandCommand {
    private static final int PRECISION = 50;
    private static final int SCALE = 15;
    private static final BigDecimal NUM2 = BigDecimal.valueOf(2);
    private static final MathContext MC = new MathContext(PRECISION, RoundingMode.HALF_UP);
    @Override
    BigDecimal getValue(CalcStackItem param) {
        return sqrt(param.getValue());
    }

    @Override
    public String getCommand() {
        return "sqrt";
    }

    private BigDecimal sqrt(BigDecimal value){
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < PRECISION) {
            deviation = (deviation.add(value.divide(deviation, MC))).divide(NUM2, MC);
            cnt++;
        }
        return deviation.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }


}
