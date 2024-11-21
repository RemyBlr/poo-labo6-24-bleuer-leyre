package calculator;

public class BackspaceOperator extends Operator {
    public BackspaceOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        String currentValue = state.getCurrentValue();
        if (currentValue.length() > 1) {
            state.setCurrentValue(currentValue.substring(0, currentValue.length() - 1));
        } else {
            state.setCurrentValue("0");
        }
    }
}
