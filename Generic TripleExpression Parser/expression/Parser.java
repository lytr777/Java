package expression;
import expression.generic.TripleExpression;

public interface Parser {
    TripleExpression parse(String expression) throws Exception;
}