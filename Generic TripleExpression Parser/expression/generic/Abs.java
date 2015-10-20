package expression.generic;

public class Abs<T extends Number> extends UnaryOperation<T> {
    public Abs(MyNumber<T> type, TripleExpression <T> x) {
        super(type, x);
    }

    protected T calc(T x) throws EvaluateException {
        return type.abs(x);
    }
}
