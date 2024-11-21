package calculator;

public class SquareRoot extends UnaryOperator {
    public SquareRoot(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        if (operand < 0) {
            throw new ArithmeticException("Error : square root of negative number");
        }
        return Math.sqrt(operand);
    }
}
