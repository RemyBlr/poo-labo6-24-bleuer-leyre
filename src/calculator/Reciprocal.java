package calculator;

public class Reciprocal extends UnaryOperator {
    public Reciprocal(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        if (operand == 0) {
            throw new ArithmeticException("Error : division by zero");
        }
        return 1.0 / operand;
    }
}
