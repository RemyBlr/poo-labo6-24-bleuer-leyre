package calculator;

/**
 * Multilication operator (*) - multiplies the stack's top operand with the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see BinaryOperator
 */
public class Multiplication extends BinaryOperator {
    public Multiplication(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 * op2;
    }
}
