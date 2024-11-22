package calculator;

/**
 * Abstract class for unary operators.
 * Unary operators are operators that only require one operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public abstract class UnaryOperator extends Operator {
    public UnaryOperator(State state) {
        super(state);
    }

    @Override
    void execute() {
        try {
            // get current value
            double operand = Double.parseDouble(state.getCurrentValue());

            // do operation
            double result = operate(operand);

            // update current value
            state.setCurrentValue(Double.toString(result));

            // reset error state
            state.setError(false);

            // set flag to indicate last action was operation
            state.setIsOperationPerformed(true);
        } catch (Exception e) {
            // set error state
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }

    /**
     * Perform the operation on the operand.
     *
     * @param operand the operand to perform the operation on
     * @return the result of the operation
     */
    protected abstract double operate(double operand);
}
