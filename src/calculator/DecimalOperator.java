package calculator;

/**
 * Decimal operator (.) - adds a decimal point to the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class DecimalOperator extends Operator {
    public DecimalOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        String currentValue = state.getCurrentValue();
        // add decimal point to current value
        if (!currentValue.contains(".")) {
            state.setCurrentValue(currentValue + ".");
        }
    }
}
