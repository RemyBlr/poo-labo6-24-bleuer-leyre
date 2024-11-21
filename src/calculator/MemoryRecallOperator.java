package calculator;

public class MemoryRecallOperator extends Operator {
    public MemoryRecallOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Double memoryValue = state.recallMemory();
        if (memoryValue != null) {
            state.setCurrentValue(memoryValue.toString());
            state.setError(false);
        } else {
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }
}
