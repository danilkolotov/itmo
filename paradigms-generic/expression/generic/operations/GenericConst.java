package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public class GenericConst<T> implements GenericExpression<T> {
    int value;
    public GenericConst(int value) {
        this.value = value;
    }

    @Override
    public T evaluate(Calculator<T> calculator, int x, int y, int z) throws EvaluationException {
        return calculator.parseConst(value);
    }
}
