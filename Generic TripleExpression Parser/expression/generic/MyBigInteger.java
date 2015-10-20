package expression.generic;

import java.math.BigInteger;

public class MyBigInteger extends MyAbstractNumber<BigInteger> {

    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public BigInteger divide(BigInteger x, BigInteger y) throws EvaluateException{
        if (y.equals(BigInteger.ZERO)) {
            throw new EvaluateException("Division by zero");
        }
        return x.divide(y);
    }

    public BigInteger negative(BigInteger x) {
        return x.negate();
    }

    public BigInteger abs(BigInteger x) {
        return x.abs();
    }

    public BigInteger makeFromInt(int x) {
        return BigInteger.valueOf(x);
    }
}
