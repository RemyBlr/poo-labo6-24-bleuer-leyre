package calculator;

public class NumberOperator extends Operator {
    private String digit;

    public NumberOperator(State state, String digit) {
        super(state);
        this.digit = digit;
    }

    @Override
    public void execute() {

        if (state.isOperationPerformed()) {
            // push currentValue to stack
            double value = Double.parseDouble(state.getCurrentValue());
            state.pushValue(value);

            // start new currentValue with pressed digit
            state.setCurrentValue(digit);
            state.setIsOperationPerformed(false);
            return;
        }

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
