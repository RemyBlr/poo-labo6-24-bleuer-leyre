package calculator;

/**
 * Clear operator (C) - clears the state
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class ClearOperator extends Operator {
    public ClearOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.clear();
    }
}
