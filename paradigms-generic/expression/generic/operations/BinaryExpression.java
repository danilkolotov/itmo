package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public abstract class BinaryExpression<T> implements GenericExpression<T> {
    GenericExpression<T> l, r;

    public BinaryExpression(GenericExpression<T> l, GenericExpression<T> r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public T evaluate(Calculator<T> calculator, int x, int y, int z) throws EvaluationException {
        return makeOperation(calculator, l.evaluate(calculator, x, y, z), r.evaluate(calculator, x, y, z));
    }

    protected abstract T makeOperation(Calculator<T> calculator, T lResult, T rResult) throws EvaluationException;
}
