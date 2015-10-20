package expression.generic;

public abstract class UnaryOperation<T extends Number> implements TripleExpression <T> {
    private TripleExpression <T> a1;
    protected MyNumber<T> type;

    protected UnaryOperation(MyNumber<T> type, TripleExpression <T> a1) {
        this.type = type;
        this.a1 = a1;
    }

    protected abstract T calc(T x) throws EvaluateException;

    public T evaluate(int x, int y, int z) throws EvaluateException {
        return calc(a1.evaluate(x, y, z));
    }
}

