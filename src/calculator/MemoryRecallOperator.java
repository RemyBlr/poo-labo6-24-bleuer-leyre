package calculator;

/**
 * MemoryRecall operator (MR) - recalls the value stored in memory.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see Operator
 */
public class MemoryRecallOperator extends Operator {
    public MemoryRecallOperator(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Double memoryValue = state.recallMemory();
        // if memory value is not null, set it as current value
        if (memoryValue != null) {
            state.setCurrentValue(memoryValue.toString());
            state.setError(false);
        } else {
            // set error state
            state.setError(true);
            state.setCurrentValue("Error");
        }
    }
}
