package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public class GenericCount<T> extends UnaryExpression<T>{
    public GenericCount(GenericExpression<T> expression) {
        super(expression);
    }

    @Override
    protected T makeOperation(Calculator<T> calculator, T expressionResult) throws EvaluationException {
        return calculator.count(expressionResult);
    }
}
