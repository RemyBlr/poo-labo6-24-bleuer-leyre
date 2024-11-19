package calculator;

public class Addition extends BinaryOperator {
    public Addition(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 + op2;
    }
}
