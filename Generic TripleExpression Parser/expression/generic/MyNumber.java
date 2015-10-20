package expression.generic;

public interface MyNumber<T extends Number> {

    public T add(T x, T y) throws EvaluateException;

    public T subtract(T x, T y) throws EvaluateException;

    public T multiply(T x, T y) throws EvaluateException;

    public T divide(T x, T y) throws EvaluateException;

    public T mod(T x, T y) throws EvaluateException;

    public T negative(T x) throws EvaluateException;

    public T abs(T x) throws EvaluateException;

    public T square(T x) throws EvaluateException;

    public T makeFromInt(int x) throws EvaluateException;

}
