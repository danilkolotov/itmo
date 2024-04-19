package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public class GenericMultiply<T> extends BinaryExpression<T> {
    public GenericMultiply(GenericExpression<T> l, GenericExpression<T> r) {
        super(l, r);
    }

    @Override
    protected T makeOperation(Calculator<T> calculator, T lResult, T rResult) throws EvaluationException {
        return calculator.multiply(lResult, rResult);
    }
}
