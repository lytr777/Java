package expression.generic;

public abstract class MyAbstractNumber<T extends Number> implements MyNumber<T> {
    public T square(T x) throws EvaluateException {
        return multiply(x, x);
    }

    public T subtract(T x, T y) throws EvaluateException {
        return add(x, negative(y));
    }

    public T mod(T x, T y) throws EvaluateException {
        return subtract(x, multiply(divide(x, y), y));
    }
}
