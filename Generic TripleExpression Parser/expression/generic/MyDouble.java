package expression.generic;

public class MyDouble extends MyAbstractNumber<Double> {

    public Double add(Double x, Double y) {
        return x + y;
    }

    public Double multiply(Double x, Double y) {
        return x * y;
    }

    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double mod(Double x, Double y) {
        return x % y;
    }

    public Double negative(Double x) {
        return -x;
    }

    public Double abs(Double x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    public Double makeFromInt(int x) {
        return (double) x;
    }
}
