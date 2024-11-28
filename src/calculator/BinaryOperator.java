package calculator;

/**
 * Abstract class for binary operators.
 * Binary operators are operators that require two operands to perform an operation.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    @Override
    void execute() {
        try {
            // pop one operand from stack and other from current value
            double op2 = Double.parseDouble(state.getCurrentValue());
            double op1 = state.popValue();

            // perform operation
            double result = operate(op1, op2);

            // update current value
            state.setCurrentValue(Double.toString(result));

            // clear error state
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
     * Perform the operation on the operands.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the result of the operation
     */
    protected abstract double operate(double a, double b);
}
