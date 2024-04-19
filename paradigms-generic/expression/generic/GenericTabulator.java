package expression.generic;
import expression.exceptions.EvaluationException;
import expression.generic.calculators.*;

public class GenericTabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        switch (mode) {
            case "bi" -> {
                return tabulateImpl(expression, new BigIntegerCalculator(), x1, x2, y1, y2, z1, z2);
            }
            case "i" -> {
                return tabulateImpl(expression, new CheckedIntegerCalculator(), x1, x2, y1, y2, z1, z2);
            }
            case "d" -> {
                return tabulateImpl(expression, new DoubleCalculator(), x1, x2, y1, y2, z1, z2);
            }
            case "u" -> {
                return tabulateImpl(expression, new UncheckedIntegerCalculator(), x1, x2, y1, y2, z1, z2);
            }
            case "b" -> {
                return tabulateImpl(expression, new ByteCalculator(), x1, x2, y1, y2, z1, z2);
            }
            case "sat" -> {
                return tabulateImpl(expression, new SaturatedIntegerCalculator(), x1, x2, y1, y2, z1, z2);
            }
            default -> throw new IllegalArgumentException("Illegal 'mode' argument");
        }
    }

    private <T> Object[][][] tabulateImpl(String expr, Calculator<T> calculator, int x1, int x2, int y1, int y2, int z1, int z2) throws IllegalArgumentException {
        GenericExpression<T> expression = new Parser<T>().parse(expr);
        Object[][][] table = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        table[i - x1][j - y1][k - z1] = expression.evaluate(calculator, i, j, k);
                    } catch (EvaluationException | ArithmeticException e) {
                        table[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return table;
    }
}
