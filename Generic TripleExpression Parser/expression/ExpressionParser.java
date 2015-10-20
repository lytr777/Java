package expression;

import expression.generic.*;

public class ExpressionParser <T extends Number> implements Parser{
    private String str;
    private int iter;
    protected MyNumber<T> type ;

    public ExpressionParser(MyNumber<T> type) {
        this.type = type;
    }

    public TripleExpression <T> parse (String exp) {
        this.str = exp;
        this.type = type;
        iter = 0;
        return expression();
    }

    private <T> void trim() {
        while (iter < str.length() && Character.isWhitespace(str.charAt(iter))) {
            iter++;
        }
    }

    private TripleExpression <T> expression() {
        TripleExpression <T> current = term();
        while ((str.length() - iter > 0) && (str.charAt(iter) == '+' || str.charAt(iter) == '-')) {
            char sign = str.charAt(iter);
            iter++;
            if (sign == '+')
                current = new Add<T>(type, current, term());
            else
                current = new Subtract<T>(type, current, term());
        }
        return current;
    }

    private TripleExpression <T> term() {
        TripleExpression <T> current = primary();
        while (((str.length() - iter > 0) && (str.charAt(iter) == '*' || str.charAt(iter) == '/'))
                || ((str.length() - iter > 2) && str.substring(iter, iter + 3).equals("mod"))) {
            if (str.charAt(iter) == '*') {
                iter++;
                current = new Multiply<T>(type, current, primary());
            } else if (str.charAt(iter) == '/') {
                iter++;
                current = new Divide<T>(type, current, primary());
            } else if ((str.length() - iter > 2) && str.substring(iter, iter + 3).equals("mod")) {
                iter += 3;
                current = new Mod<T>(type, current, primary());
            }
        }
        return current;
    }

    private TripleExpression <T> primary() {
        if (str.length() - iter > 0 && str.charAt(iter) == '(') {
            iter++;
            TripleExpression <T> d = expression();
            iter++;
            trim();
            return d;
        } else {
            return functionVarNum();
        }
    }

    private TripleExpression <T> functionVarNum() {
        boolean negative = false, isFunction = false;
        while (str.length() - iter > 0 && (str.charAt(iter) == '-' || Character.isWhitespace(str.charAt(iter)))) {
            if (str.charAt(iter) == '-')
                negative = !negative;
            iter++;
        }
        if (negative) {
            return new Negative<T>(type, primary());
        }
        if (str.length() - iter > 0 && str.charAt(iter) == '(') {
            return primary();
        }

        int i = iter;
        while (i < str.length() && (Character.isDigit(str.charAt(i)) || (Character.isLetter(str.charAt(i))))) {
            if (!Character.isDigit(str.charAt(i)))
                isFunction = true;
            i++;
        }
        String tmp = str.substring(iter, i);
        iter = i;
        trim();

        if (!isFunction) {
            return new Const<T>(type, Integer.parseInt(tmp));
        }
        if (tmp.equals("x") || tmp.equals("y") || tmp.equals("z")) {
            return new Variable<T>(type, tmp);
        }
        if (tmp.equals("abs")) {
            return new Abs<T>(type, primary());
        }
        if (tmp.equals("square")) {
            return new Square<T>(type, primary());
        }

        return null;
    }
}
