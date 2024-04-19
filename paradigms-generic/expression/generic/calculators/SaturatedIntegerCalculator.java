package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;
import expression.generic.calculators.Calculator;

public class SaturatedIntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(Integer a, Integer b) {
        if (a >= 0){
            if (Integer.MAX_VALUE - a < b){
                return Integer.MAX_VALUE;
            }
        } else {
            if (Integer.MIN_VALUE - a > b){
                return Integer.MIN_VALUE;
            }
        }
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        if (a < 0){
            if (b > a - Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        } else {
            if (b < - (Integer.MAX_VALUE - a)) {
                return Integer.MAX_VALUE;
            }
        }
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if (a > 0) {
            if (b > 0 && Integer.MAX_VALUE / a < b) {
                return Integer.MAX_VALUE;
            } else if (b < 0 && Integer.MIN_VALUE / a > b) {
                return Integer.MIN_VALUE;
            }
        } else if (a < 0) {
            if (a == -1) {
                if (b == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return a * b;
            }
            if (b < 0) {
                if (Integer.MAX_VALUE / a > b) {
                    return Integer.MAX_VALUE;
                }
            }
            else if (Integer.MIN_VALUE / a < b){
                return Integer.MIN_VALUE;
            }
        }
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) throws DivisionByZeroException {
        if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        if (b == 0){
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    @Override
    public Integer negate(Integer a){
        if (a == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return -a;
    }

    @Override
    public Integer count(Integer a) {
        return Integer.bitCount(a);
    }

    @Override
    public Integer min(Integer a, Integer b) {
        return Integer.min(a, b);
    }

    @Override
    public Integer max(Integer a, Integer b) {
        return Integer.max(a, b);
    }

    @Override
    public Integer parseConst(int value) {
        return value;
    }
}
