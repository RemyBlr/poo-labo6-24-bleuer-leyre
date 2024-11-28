package calculator;

/**
 * ClearEntry operator (CE) - clears the current operand.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class ClearEntryOperator extends Operator {
    public ClearEntryOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.clearEntry();
    }
}
