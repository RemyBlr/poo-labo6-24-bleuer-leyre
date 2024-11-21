package calculator;

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
