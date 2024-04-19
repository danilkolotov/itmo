package expression.generic.operations;

import expression.exceptions.EvaluationException;
import expression.generic.calculators.Calculator;
import expression.generic.GenericExpression;

public class GenericVariable<T> implements GenericExpression<T> {
    String name;
    public GenericVariable(String name) {
        this.name = name;
    }

    @Override
    public T evaluate(Calculator<T> calculator, int x, int y, int z) throws EvaluationException {
        return switch (name) {
          case "x" -> calculator.parseConst(x);
          case "y" -> calculator.parseConst(y);
          case "z" -> calculator.parseConst(z);
          default -> throw new IllegalStateException();
        };
    }
}
