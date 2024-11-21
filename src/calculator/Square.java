package calculator;

public class Square extends UnaryOperator {
    public Square(State state) {
        super(state);
    }

    @Override
    protected double operate(double operand) {
        return operand * operand;
    }
}
