package expression.generic.calculators;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;

public class UncheckedIntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(Integer a, Integer b) throws EvaluationException {
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) throws EvaluationException {
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) throws EvaluationException {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) throws EvaluationException {
        return a / b;
    }

    @Override
    public Integer negate(Integer a) throws EvaluationException {
        return -a;
    }

    @Override
    public Integer count(Integer a) throws EvaluationException {
        return Integer.bitCount(a);
    }

    @Override
    public Integer min(Integer a, Integer b) throws EvaluationException {
        return Integer.min(a, b);
    }

    @Override
    public Integer max(Integer a, Integer b) throws EvaluationException {
        return Integer.max(a, b);
    }

    @Override
    public Integer parseConst(int value) {
        return value;
    }
}
