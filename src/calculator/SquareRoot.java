package calculator;

/**
 * SquareRoot operator (sqrt) - calculates the square root of the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see UnaryOperator
 */
public class SquareRoot extends UnaryOperator {
    public SquareRoot(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        // can't take square root of negative number
        if (operand < 0) {
            throw new ArithmeticException("Error : square root of negative number");
        }
        return Math.sqrt(operand);
    }
}
