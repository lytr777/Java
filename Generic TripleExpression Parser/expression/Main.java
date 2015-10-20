package expression;
import expression.generic.*;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws EvaluateException{
        String exp = "1 + 5 mod 3";
        int aa = -7;
        int bb = -13;
        int cc = -17;

       /* TripleExpression a = new ExpressionParser<Integer>().parse(new MyIntegerOverflow(), exp);
        System.out.println(a.evaluate(aa, bb, cc));

        TripleExpression b = new ExpressionParser<BigInteger>().parse(new MyBigInteger(), exp);
        System.out.println(b.evaluate(aa, bb, cc));*/
    }
}