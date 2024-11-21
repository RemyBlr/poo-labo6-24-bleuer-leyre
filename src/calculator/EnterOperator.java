package calculator;

public class EnterOperator extends Operator {
    public EnterOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        try {
            String currentValue = state.getCurrentValue();
            double value = Double.parseDouble(currentValue);
            state.pushValue(value);
            state.setCurrentValue("0");
            state.setError(false);
            state.setIsOperationPerformed(false);
        } catch (NumberFormatException e) {
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }
}
