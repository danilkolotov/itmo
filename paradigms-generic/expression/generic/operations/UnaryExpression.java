package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public abstract class UnaryExpression<T> implements GenericExpression<T> {
    GenericExpression<T> expression;

    public UnaryExpression(GenericExpression<T> expression) {
        this.expression = expression;
    }

    @Override
    public T evaluate(Calculator<T> calculator, int x, int y, int z) throws EvaluationException {
        return makeOperation(calculator, expression.evaluate(calculator, x, y, z));
    }

    protected abstract T makeOperation(Calculator<T> calculator, T expressionResult) throws EvaluationException;
}
