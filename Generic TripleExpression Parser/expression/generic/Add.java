package expression.generic;

public class Add<T extends Number> extends BinaryOperation<T> {
    public Add(MyNumber<T> type, TripleExpression <T> x, TripleExpression <T> y) {
        super(type, x, y);
    }

    protected T calc(T x, T y) throws EvaluateException {
        return type.add(x, y);
    }
}
