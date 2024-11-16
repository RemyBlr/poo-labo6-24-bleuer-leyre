package calculator;


public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    @Override
    void execute() {
        try {
            // pop two operands from stack
            double op2 = state.popValue();
            double op1 = state.popValue();

            // perform operation
            double result = operate(op1, op2);

            // push result back to stack
            state.pushValue(result);

            // update current value
            state.setCurrentValue(Double.toString(result));

            // clear error state
            state.setError(false);
        } catch (Exception e) {
            // set error state
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }

    abstract double operate(double a, double b);
}
