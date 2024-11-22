package calculator;

/**
 * Reciprocal operator (1/x) - calculates the reciprocal of the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see UnaryOperator
 */
public class Reciprocal extends UnaryOperator {
    public Reciprocal(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        // can't divide by zero
        if (operand == 0) {
            throw new ArithmeticException("Error : division by zero");
        }
        return 1.0 / operand;
    }
}
