package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;

public class CheckedIntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(Integer a, Integer b) throws OverflowException {
        if (a >= 0){
            if (Integer.MAX_VALUE - a < b){
                throw new OverflowException(a, b, "+");
            }
        } else {
            if (Integer.MIN_VALUE - a > b){
                throw new OverflowException(a, b, "+");
            }
        }
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) throws OverflowException {
        if (a < 0){
            if (b > a - Integer.MIN_VALUE){
                throw new OverflowException(a, b, "-");
            }
        } else {
            if (b < - (Integer.MAX_VALUE - a)){
                throw new OverflowException(a, b, "-");
            }
        }
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) throws OverflowException {
        if (a > 0) {
            if (b > 0 && Integer.MAX_VALUE / a < b) {
                throw new OverflowException(a, b, "*");
            } else if (b < 0 && Integer.MIN_VALUE / a > b) {
                throw new OverflowException(a, b, "*");
            }
        } else if (a < 0) {
            if (a == -1) {
                if (b == Integer.MIN_VALUE) {
                    throw new OverflowException(a, b, "*");
                }
                return a * b;
            }
            if (b < 0) {
                if (Integer.MAX_VALUE / a > b) {
                    throw new OverflowException(a, b, "*");
                }
            }
            else if (Integer.MIN_VALUE / a < b){
                throw new OverflowException(a, b, "*");
            }
        }
        return a * b;
    }

    @Override
    public Integer divide(Integer l, Integer r) throws OverflowException, DivisionByZeroException {
        if (l == Integer.MIN_VALUE && r == -1){
            throw new OverflowException(l, r, "/");
        }
        if (r == 0){
            throw new DivisionByZeroException();
        }
        return l / r;
    }

    @Override
    public Integer negate(Integer a) throws OverflowException{
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException(a, "-");
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
