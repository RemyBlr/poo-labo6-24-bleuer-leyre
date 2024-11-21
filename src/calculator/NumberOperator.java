package calculator;

public class NumberOperator extends Operator {
    private String digit;

    public NumberOperator(State state, String digit) {
        super(state);
        this.digit = digit;
    }

    @Override
    public void execute() {
        // gestion d'erruer ?

        String currentVal = state.getCurrentValue();
        if (currentVal.equals("0")) {
            state.setCurrentValue(digit);
        } else {
            state.setCurrentValue(currentVal + digit);
        }
    }
}
