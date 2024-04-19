package expression.exceptions;

public class OverflowException extends EvaluationException {
    public OverflowException(Integer a, Integer b, String oper) {
        super(a + " " + oper + " " + b + " overflows.");
    }

    public OverflowException(Integer a, String oper) {
        super(oper + a + " overflows.");
    }
}
