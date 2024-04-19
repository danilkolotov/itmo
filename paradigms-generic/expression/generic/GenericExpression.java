package expression.generic;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;

public interface GenericExpression<T> {
    T evaluate(Calculator<T> calculator, int x, int y, int z) throws EvaluationException;
}
