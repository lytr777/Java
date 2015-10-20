package expression.generic;

public class MyIntegerOverflow extends MyAbstractNumber<Integer> {

    public Integer add(Integer x, Integer y) throws EvaluateException{
        int res = x + y;
        if (((res ^ x) & (res ^ y)) < 0) {
            throw new EvaluateException("Overflow");
        }
        return res;
    }

    public Integer multiply(Integer x, Integer y) throws EvaluateException {
        int res = x * y;
        if ((x | y) >> 15 != 0) {
            if (((y != 0) && (res / y != x)) || (x == Integer.MIN_VALUE && y == -1) || (x == -1 && y == Integer.MIN_VALUE)) {
                throw new EvaluateException("Overflow");
            }
        }
        return res;
    }

    public Integer divide(Integer x, Integer y) throws EvaluateException {
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new EvaluateException("Overflow");
        }
        if (y == 0) {
            throw new EvaluateException("Division by zero");
        }
        return x / y;
    }

    public Integer negative(Integer x) throws EvaluateException {
        if (x == Integer.MIN_VALUE) {
            throw new EvaluateException("Overflow");
        }
        return -x;
    }

    public Integer abs(Integer x) throws EvaluateException {
        if (x == Integer.MIN_VALUE) {
            throw new EvaluateException("Overflow");
        }
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
