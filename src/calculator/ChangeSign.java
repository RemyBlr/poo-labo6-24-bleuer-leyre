package calculator;

/**
 * ChangeSign operator (+/-) - changes the sign of the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see UnaryOperator
 */
public class ChangeSign extends UnaryOperator {
    public ChangeSign(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        return -operand;
    }
}
