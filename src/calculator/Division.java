package calculator;

public class Division extends BinaryOperator {
    public Division(State state) {
        super(state);
    }

    @Override
    protected double operate(double op1, double op2) {
        return op1 / op2;
    }
}
