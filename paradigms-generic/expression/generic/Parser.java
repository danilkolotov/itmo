package expression.generic;

import expression.generic.parser.*;
import expression.generic.operations.*;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Parser<T> {
    public GenericExpression<T> parse(String expression) {
        return (new ParserImpl<T>(new ReturnableStringSource(expression))).parse();
    }

    private static class ParserImpl<T> extends ReturnableBaseParser {
        private final List<Map<String, BiFunction<GenericExpression<T>, GenericExpression<T>, GenericExpression<T>>>> operationSet =
                List.of(
                        Map.ofEntries(
                                Map.entry("min", GenericMin::new),
                                Map.entry("max", GenericMax::new)
                        ),
                        Map.ofEntries(
                                Map.entry("+", GenericAdd::new),
                                Map.entry("-", GenericSubtract::new)
                        ),
                        Map.ofEntries(
                                Map.entry("*", GenericMultiply::new),
                                Map.entry("/", GenericDivide::new)
                        )
                );

        private ParserImpl(ReturnableCharSource source) {
            super(source);
        }

        private GenericExpression<T> parse() {
            return parseSet(0);
        }

        private GenericExpression<T> parseSet(int currentSetIndex) {
            if (currentSetIndex == operationSet.size()) {
                return parseMulDiv();
            }
            var currentSet = operationSet.get(currentSetIndex);
            skipSpaces();
            GenericExpression<T> first = parseSet(currentSetIndex + 1);
            while (!eof()) {
                skipSpaces();
                boolean toBreak = true;
                for (String s : currentSet.keySet()) {
                    if (checkString(s)) {
                        first = currentSet.get(s).apply(first, parseSet(currentSetIndex + 1));
                        toBreak = false;
                        break;
                    }
                }
                if (toBreak) {
                    break;
                }
            }
            return first;

        }

        private GenericExpression<T> parseMulDiv() {
            skipSpaces();
            if (take('(')) {
                GenericExpression<T> res = parse();
                expect(')');
                return res;
            } else if (take('c')) {
                expect("ount");
                return new GenericCount<>(parseMulDiv());
            } else if (take('x')) {
                return new GenericVariable<>("x");
            } else if (take('y')) {
                return new GenericVariable<>("y");
            }
            if (take('z')) {
                return new GenericVariable<>("z");
            }
            if (take('-')) {
                if (!between('0', '9')) {
                    return new GenericNegate<>(parseMulDiv());
                } else {
                    return parseNumber(true);
                }
            }
            return parseNumber(false);
        }


        private GenericExpression<T> parseNumber(boolean minus) {
            skipSpaces();
            StringBuilder res = new StringBuilder(minus || take('-') ? "-" : "");
            while (between('0', '9')) {
                res.append(take());
            }
            try {
                return new GenericConst<>(Integer.parseInt(res.toString()));
            } catch (NumberFormatException e) {
                throw error("can't parse int");
            }
        }

        private void skipSpaces() {
            while (take(' ')) { }
        }
    }
}
