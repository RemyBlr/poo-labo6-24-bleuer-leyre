package calculator;

public class ClearEntryOperator extends Operator {
    public ClearEntryOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.clearEntry();
    }
}
