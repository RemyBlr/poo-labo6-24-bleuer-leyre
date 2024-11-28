package calculator;

/**
 * Backspace operator (<=) - removes the last digit from the current value
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class BackspaceOperator extends Operator {
    public BackspaceOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        String currentValue = state.getCurrentValue();
        // remove last character from current value
        if (currentValue.length() > 1) {
            state.setCurrentValue(currentValue.substring(0, currentValue.length() - 1));
        } else {
            // add 0 if we remove the last digit
            state.setCurrentValue("0");
        }
    }
}
