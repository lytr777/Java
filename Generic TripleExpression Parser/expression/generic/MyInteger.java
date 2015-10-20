package expression.generic;

public class MyInteger extends MyAbstractNumber<Integer> {

    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    public Integer divide(Integer x, Integer y) throws EvaluateException {
        if (y == 0) {
            throw new EvaluateException("Division by zero");
        }
        return x / y;
    }

    public Integer negative(Integer x) throws EvaluateException {
        return -x;
    }

    public Integer abs(Integer x) throws EvaluateException {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    public Integer makeFromInt(int x) throws EvaluateException {
        return x;
    }
}
