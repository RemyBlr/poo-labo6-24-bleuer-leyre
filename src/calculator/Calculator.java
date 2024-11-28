package calculator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Runs the calculator in console mode and re-uses the State and Operator classes
 * /!\ Backspace, Enter and clearEntry are not included in this mode as number are inputted as one line
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
public class Calculator {
    private final State state;
    private final HashMap<String, Operator> operators;

    public Calculator() {
        this.state = new State();
        this.operators = new HashMap<>();
        initOperators();
    }

    /**
     * Initializes the operators.
     * Operators like decimal, number, enter, clear entry are not needed.
     */
    private void initOperators() {
        // binary operators
        operators.put("+", new Addition(state));
        operators.put("-", new Subtraction(state));
        operators.put("*", new Multiplication(state));
        operators.put("/", new Division(state));
        // unary operators
        operators.put("sqrt", new SquareRoot(state));
        operators.put("1/x", new Reciprocal(state));
        operators.put("x^2", new Square(state));
        operators.put("+/-", new ChangeSign(state));
        // misc operators
        operators.put("c", new ClearOperator(state));
        operators.put("ms", new MemoryStoreOperator(state));
        operators.put("mr", new MemoryRecallOperator(state));
    }

    /**
     * Displays the stack to the console.
     */
    public String displayState() {
        String stack = state.stackToString();
        String space = Objects.equals(stack, "") ? "" : " ";
        return  state.getCurrentValue() + space + state.stackToString();
    }

    /**
     * Checks if a string is numeric.
     * @param str the string to check
     * @return true if string is numeric
     */
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Runs the calculator.
     * User can input commands.
     */
    public void run(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String input;

        System.out.println("java Calculator. Type 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            // exit calculator
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (isNumeric(input)) {
                if (state.isOperationPerformed()){
                    //push value to stack to free current value
                    new EnterOperator(state).execute();
                }
                // it's like pressing number operator
                double value = Double.parseDouble(input);
                state.setCurrentValue(Double.toString(value));
                state.setIsOperationPerformed(true);
            }
            else {
                // check if operator is not a number
                Operator operator = operators.get(input.toLowerCase());
                if (operator != null) {
                    operator.execute();
                } else {
                    System.out.println("Unknown command or operator: " + input);
                    continue;
                }
            }
            // display current value + stack
            System.out.println(displayState());
        }
        scanner.close();
        System.out.println("Calculator closed.");
    }

    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run(System.in);
    }
}
