package expression.generic;

public class Divide<T extends Number> extends BinaryOperation<T> {
    public Divide(MyNumber<T> type, TripleExpression <T> x, TripleExpression <T> y) {
        super(type, x, y);
    }

    protected T calc(T x, T y) throws EvaluateException {
        return type.divide(x, y);
    }
}
