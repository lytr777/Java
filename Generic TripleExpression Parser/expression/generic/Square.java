package expression.generic;

public class Square<T extends Number> extends UnaryOperation<T> {
    public Square(MyNumber<T> type, TripleExpression <T> x) {
        super(type, x);
    }

    protected T calc(T x) throws EvaluateException {
        return type.square(x);
    }
}
