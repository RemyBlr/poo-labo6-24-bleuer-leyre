package calculator;

public class Subtraction extends BinaryOperator {
    public Subtraction(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 - op2;
    }
}
