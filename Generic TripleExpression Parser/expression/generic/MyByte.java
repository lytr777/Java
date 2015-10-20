package expression.generic;

public class MyByte extends MyAbstractNumber<Byte> {

    public Byte add(Byte x, Byte y) {
        return (byte) (x + y);
    }

    public Byte multiply(Byte x, Byte y) {
        return (byte) (x * y);
    }

    public Byte divide(Byte x, Byte y) throws EvaluateException {
        if (y == 0) {
            throw new EvaluateException("Division by zero");
        }
        return (byte) (x / y);
    }

    public Byte negative(Byte x) throws EvaluateException {
        return (byte) -x;
    }

    public Byte abs(Byte x) throws EvaluateException {
        if (x >= 0) {
            return x;
        } else {
            return (byte) -x;
        }
    }

    public Byte makeFromInt(int x) throws EvaluateException {
        return (byte) x;
    }
}
