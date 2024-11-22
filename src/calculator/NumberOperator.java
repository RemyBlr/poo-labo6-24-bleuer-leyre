package calculator;

/**
 * Number operator (0-9) - appends the digit to the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class NumberOperator extends Operator {
    private String digit;

    public NumberOperator(State state, String digit) {
        super(state);
        this.digit = digit;
    }

    @Override
    public void execute() {

        // reset current value if error
        if(state.isError()) {
            state.clearEntry();
            // don't want to push 0 to stack if error
            state.setIsOperationPerformed(false);
        }

        // if operation is performed, start new currentValue
        if (state.isOperationPerformed()) {
            // push currentValue to stack
            double value = Double.parseDouble(state.getCurrentValue());
            state.pushValue(value);

            // start new currentValue with pressed digit
            state.setCurrentValue(digit);
            state.setIsOperationPerformed(false);
            return;
        }

        // check if current vvalue exists
        String currentVal = state.getCurrentValue();
        if (currentVal.equals("0")) {
            state.setCurrentValue(digit);
        } else {
            state.setCurrentValue(currentVal + digit);
        }

        // reset operation performed
        state.setIsOperationPerformed(false);
    }
}
