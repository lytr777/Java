package expression.generic;

public class Mod<T extends Number> extends BinaryOperation<T> {
    public Mod(MyNumber<T> type, TripleExpression <T> x, TripleExpression <T> y) {
        super(type, x, y);
    }

    protected T calc(T x, T y) throws EvaluateException {
        return type.mod(x, y);
    }
}
