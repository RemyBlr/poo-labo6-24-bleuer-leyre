package calculator;

/**
 * Addition operator (+) - adds the stack's top operand to the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see BinaryOperator
 */
public class Addition extends BinaryOperator {
    public Addition(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 + op2;
    }
}
