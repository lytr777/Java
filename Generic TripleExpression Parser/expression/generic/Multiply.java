package expression.generic;

public class Multiply<T extends Number> extends BinaryOperation<T> {
    public Multiply(MyNumber<T> type, TripleExpression <T> x, TripleExpression <T> y) {
        super(type, x, y);
    }

    protected T calc(T x, T y) throws EvaluateException {
        return type.multiply(x, y);
    }
}
