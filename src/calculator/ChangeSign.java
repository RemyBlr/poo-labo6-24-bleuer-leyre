package calculator;

public class ChangeSign extends UnaryOperator {
    public ChangeSign(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        return -operand;
    }
}
