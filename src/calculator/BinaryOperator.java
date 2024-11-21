package calculator;


public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    @Override
    void execute() {
        try {
            // pop two operands from stack
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

    abstract double operate(double a, double b);
}
