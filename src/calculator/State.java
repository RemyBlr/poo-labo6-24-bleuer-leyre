package calculator;
import calculator.util.Stack;

public class State {
    private String currentValue;
    private Stack<Double> stack;
    private Double memory;
    private boolean error;

    public State() {
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.memory = null;
        this.error = false;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String value) {
        this.currentValue = value;
    }

    public void pushValue(double value) {
        stack.push(value);
    }

    public double popValue() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stack.pop();
    }

    public void storeMemory(double value) {
        this.memory = value;
    }

    public Double recallMemory() {
        return memory;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void clear() {
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.error = false;
    }
}