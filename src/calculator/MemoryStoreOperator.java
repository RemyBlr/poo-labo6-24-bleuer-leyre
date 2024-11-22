package calculator;

/**
 * MemoryStore operator (MS) - stores the current operand in memory.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 * @see UnaryOperator
 */
public class MemoryStoreOperator extends UnaryOperator {
    public MemoryStoreOperator(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        state.storeMemory(operand);
        return operand;
    }
}
