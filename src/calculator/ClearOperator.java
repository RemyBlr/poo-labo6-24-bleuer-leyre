package calculator;

public class ClearOperator extends Operator {
    public ClearOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.clear();
    }
}
