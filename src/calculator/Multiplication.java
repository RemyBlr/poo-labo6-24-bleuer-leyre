package calculator;

public class Multiplication extends BinaryOperator {
    public Multiplication(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 * op2;
    }
}
