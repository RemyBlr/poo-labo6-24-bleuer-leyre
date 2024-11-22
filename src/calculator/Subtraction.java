package calculator;

/**
 * Subtraction operator (-) - subtracts the stack's top operand from the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see BinaryOperator
 */
public class Subtraction extends BinaryOperator {
    public Subtraction(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 - op2;
    }
}
