package expression.generic;

import expression.ExpressionParser;

import java.math.BigInteger;

public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Object[][][] o = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        TripleExpression b;
        switch (mode) {
            case "i":
                b = new ExpressionParser<Integer>(new MyIntegerOverflow()).parse(expression);
                break;
            case "d":
                b = new ExpressionParser<Double>(new MyDouble()).parse(expression);
                break;
            case "bi":
                b = new ExpressionParser<BigInteger>(new MyBigInteger()).parse(expression);
                break;
            case "f":
                b = new ExpressionParser<Float>(new MyFloat()).parse(expression);
                break;
            case "b":
                b = new ExpressionParser<Byte>(new MyByte()).parse(expression);
                break;
            default:
                b = new ExpressionParser<Integer>(new MyInteger()).parse(expression);
                break;
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        o[i - x1][j - y1][k - z1] = b.evaluate(i, j, k);
                    }
                    catch (EvaluateException e) {
                        o[i - x1][j - y1][k - z1] = null;
                    }
                    //System.out.println(expression + " " + (i - x1 )+ " " + (j - y1 )+ " " + (k - z1) + " " + o[i - x1][j - y1][k - z1]);
                }
            }
        }
        return o;
    }
}
