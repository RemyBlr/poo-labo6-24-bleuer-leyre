package calculator;
import calculator.util.Stack;

import java.util.Iterator;

public class State {
    private String currentValue;
    private Stack<Double> stack;
    private Double memory;
    private boolean error;
    private boolean isOperationPerformed;


    public State() {
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.memory = null;
        this.error = false;
        this.isOperationPerformed = false;

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

    public Double[] getStackValues() {
        Double[] a = new Double[stack.size()];
        return stack.toArray(a);
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

    public Iterator<Double> getStackIterator() {
        return stack.iterator();
    }

    public boolean isOperationPerformed() {
        return isOperationPerformed;
    }

    public void setIsOperationPerformed(boolean value) {
        this.isOperationPerformed = value;
    }
}