package expression.generic;

public class MyFloat extends MyAbstractNumber<Float> {

    public Float add(Float x, Float y) {
        return x + y;
    }

    public Float multiply(Float x, Float y) {
        return x * y;
    }

    public Float divide(Float x, Float y) {
        return x / y;
    }

    @Override
    public Float mod(Float x, Float y) {
        return x % y;
    }

    public Float negative(Float x) {
        return -x;
    }

    public Float abs(Float x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    public Float makeFromInt(int x) {
        return (float) x;
    }
}
