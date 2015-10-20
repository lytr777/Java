package expression.generic;

public class Variable<T extends Number> implements TripleExpression <T> {
    protected MyNumber<T> type;
    private String var;

    public Variable(MyNumber<T> type, String args) {
        this.type = type;
        var = args;
    }

    public T evaluate(int x, int y, int z) throws EvaluateException {
        if (var.equals("x")) return type.makeFromInt(x);
        if (var.equals("y")) return type.makeFromInt(y);
        return type.makeFromInt(z);
    }
}
