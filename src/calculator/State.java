package calculator;
import calculator.util.Stack;

import java.util.Iterator;

/**
 * The state of the calculator.
 * It contains the current value, the stack, the memory, the error state.
 * The current value is the value displayed on the calculator screen.
 * The stack is used to store the values if the operations
 * The error state is set to true if an error occurs.
 * The memory is used to store a value.
 * The isOperationPerformed flag is used to indicate if the last action was an operation.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
public class State {
    private String currentValue;
    private Stack<Double> stack;
    private Double memory;
    private boolean error;
    private boolean isOperationPerformed;


    /**
     * Constructor for the state.
     */
    public State() {
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.memory = null;
        this.error = false;
        this.isOperationPerformed = false;

    }

    /**
     * Get the current value.
     *
     * @return the current value
     */
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * Set the current value.
     *
     * @param value the value to set
     */
    public void setCurrentValue(String value) {
        this.currentValue = value;
    }

    /**
     * Push a value to the stack.
     *
     * @param value the value to push
     */
    public void pushValue(double value) {
        stack.push(value);
    }

    /**
     * Pop a value from the stack.
     *
     * @return the value popped from the stack
     * @throws Exception if the stack is empty
     */
    public double popValue() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stack.pop();
    }

    /**
     * Get the values from the stack.
     *
     * @return the values from the stack
     */
    public Double[] getStackValues() {
        Double[] a = new Double[stack.size()];
        return stack.toArray(a);
    }

    /**
     * Store a value in memory.
     *
     * @param value the value to store
     */
    public void storeMemory(double value) {
        this.memory = value;
    }

    /**
     * Recall the value from memory.
     *
     * @return the value stored in memory
     */
    public Double recallMemory() {
        return memory;
    }

    /**
     * Return the error state.
     *
     * @return true if an error occurred
     */
    public boolean isError() {
        return error;
    }

    /**
     * Set the error state.
     *
     * @param error the error state to set
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Clear the state.
     */
    public void clear() {
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.error = false;
    }

    /**
     * Clear the current value.
     */
    public void clearEntry() {
        this.currentValue = "0";
        this.error = false;
        this.isOperationPerformed = false;
    }

    public Iterator<Double> getStackIterator() {
        return stack.iterator();
    }

    /**
     * Get the isOperationPerformed flag.
     *
     * @return true if the last action was an operation
     */
    public boolean isOperationPerformed() {
        return isOperationPerformed;
    }

    /**
     * Set the isOperationPerformed flag.
     *
     * @param value the value to set
     */
    public void setIsOperationPerformed(boolean value) {
        this.isOperationPerformed = value;
    }
}