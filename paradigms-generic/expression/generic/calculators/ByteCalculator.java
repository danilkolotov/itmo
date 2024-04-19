package expression.generic.calculators;

import expression.exceptions.EvaluationException;

public class ByteCalculator implements Calculator<Byte> {
    @Override
    public Byte add(Byte a, Byte b) throws EvaluationException {
        return (byte) (a + b);
    }

    @Override
    public Byte subtract(Byte a, Byte b) throws EvaluationException {
        return (byte) (a - b);
    }

    @Override
    public Byte multiply(Byte a, Byte b) throws EvaluationException {
        return (byte) (a * b);
    }

    @Override
    public Byte divide(Byte a, Byte b) throws EvaluationException {
        return (byte) (a / b);
    }

    @Override
    public Byte negate(Byte a) throws EvaluationException {
        return (byte) -a;
    }

    @Override
    public Byte count(Byte a) throws EvaluationException {
        return (byte) Integer.bitCount(Byte.toUnsignedInt(a));
    }

    @Override
    public Byte min(Byte a, Byte b) throws EvaluationException {
        return (byte) Integer.min((int) a, (int) b);
    }

    @Override
    public Byte max(Byte a, Byte b) throws EvaluationException {
        return (byte) Integer.max((int) a, (int) b);
    }

    @Override
    public Byte parseConst(int value) {
        return (byte) value;
    }
}
