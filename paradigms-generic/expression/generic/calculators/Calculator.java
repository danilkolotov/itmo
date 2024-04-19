package expression.generic.calculators;

import expression.exceptions.EvaluationException;

public interface Calculator<T> {
    T add(T a, T b) throws EvaluationException;
    T subtract(T a, T b) throws EvaluationException;
    T multiply(T a, T b) throws EvaluationException;
    T divide(T a, T b) throws EvaluationException;
    T negate(T a) throws EvaluationException;
    T count(T a) throws EvaluationException;
    T min(T a, T b) throws EvaluationException;
    T max(T a, T b) throws EvaluationException;

    T parseConst(int value);
}
