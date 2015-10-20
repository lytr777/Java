package expression.generic;

public class Negative<T extends Number> extends UnaryOperation<T> {
    public Negative(MyNumber<T> type, TripleExpression <T> x) {
        super(type, x);
    }

    protected T calc(T x) throws EvaluateException {
        return type.negative(x);
    }
}
