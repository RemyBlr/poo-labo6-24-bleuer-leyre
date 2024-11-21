package calculator;

public class DecimalOperator extends Operator {
    public DecimalOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        String currentValue = state.getCurrentValue();
        if (!currentValue.contains(".")) {
            state.setCurrentValue(currentValue + ".");
        }
    }
}
