package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public class GenericNegate<T> extends UnaryExpression<T>{
    public GenericNegate(GenericExpression<T> expression) {
        super(expression);
    }

    @Override
    protected T makeOperation(Calculator<T> calculator, T expressionResult) throws EvaluationException {
        return calculator.negate(expressionResult);
    }
}
