package calculator;

/**
 * Enter operator (Ent) - pushes the current value to the stack.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class EnterOperator extends Operator {
    public EnterOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        try {
            String currentValue = state.getCurrentValue();
            double value = Double.parseDouble(currentValue);
            // push current value to stack
            state.pushValue(value);
            state.setCurrentValue("0");
            state.setError(false);
            // set flag to false
            state.setIsOperationPerformed(false);
        } catch (NumberFormatException e) {
            // set error state
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }
}
