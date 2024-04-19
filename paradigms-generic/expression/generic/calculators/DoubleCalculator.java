package expression.generic.calculators;

import expression.exceptions.EvaluationException;

public class DoubleCalculator implements Calculator<Double> {
    @Override
    public Double add(Double a, Double b) throws EvaluationException {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) throws EvaluationException {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) throws EvaluationException {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) throws EvaluationException {
        return a / b;
    }

    @Override
    public Double negate(Double a) throws EvaluationException {
        return -a;
    }

    @Override
    public Double count(Double a) throws EvaluationException {
        return (double) Long.bitCount(Double.doubleToLongBits(a));
    }

    @Override
    public Double min(Double a, Double b) throws EvaluationException {
        return Double.min(a, b);
    }

    @Override
    public Double max(Double a, Double b) throws EvaluationException {
        return Double.max(a, b);
    }

    @Override
    public Double parseConst(int value) {
        return (double) value;
    }
}
