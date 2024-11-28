package calculator;

/**
 * Square operator (x^2) - calculates the square of the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see UnaryOperator
 */
public class Square extends UnaryOperator {
    public Square(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        return operand * operand;
    }
}
