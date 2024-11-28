package calculator;

/**
 * Division operator (/) - divides the stack's top operand by the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see BinaryOperator
 */
public class Division extends BinaryOperator {
    public Division(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        // can't divide by zero
        if (op2 == 0) {
            throw new ArithmeticException("Error : division by zero");
        }
        return op1 / op2;
    }
}
