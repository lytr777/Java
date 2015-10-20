package expression.generic;

public class Subtract<T extends Number> extends BinaryOperation<T> {
    public Subtract(MyNumber<T> type, TripleExpression <T> x, TripleExpression <T> y) {
        super(type, x, y);
    }

    protected T calc(T x, T y) throws EvaluateException {
        return type.subtract(x, y);
    }
}
