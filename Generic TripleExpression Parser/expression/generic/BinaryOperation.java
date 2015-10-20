package expression.generic;

public abstract class BinaryOperation<T extends Number> implements TripleExpression <T>{
    private TripleExpression <T> a1, a2;
    protected MyNumber<T> type;

    protected BinaryOperation(MyNumber<T> type, TripleExpression<T> a1, TripleExpression<T> a2) {
        this.a1 = a1;
        this.a2 = a2;
        this.type = type;
    }

    protected abstract T calc(T x, T y) throws EvaluateException;

    public T evaluate(int x, int y, int z) throws EvaluateException {
        return calc(a1.evaluate(x, y, z), a2.evaluate(x, y, z));
    }

}