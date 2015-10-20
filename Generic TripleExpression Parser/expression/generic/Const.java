package expression.generic;

public class Const<T extends Number> implements TripleExpression <T> {
    protected MyNumber<T> type;
    private int a;

    public Const(MyNumber<T> type, int x) {
        this.type = type;
        this.a = x;
    }

    public T evaluate(int x, int y, int z) throws EvaluateException {
        return type.makeFromInt(a);
    }
}
