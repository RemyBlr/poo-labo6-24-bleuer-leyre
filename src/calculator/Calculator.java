package calculator;

import java.util.HashMap;
import java.util.Scanner;

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
     * Operators like deccimal, number, enter, clear entry are not needed.
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
    public void displayStack() {
        Double[] stackValues = state.getStackValues();
        // no values in the stack
        if (stackValues.length == 0) {
            System.out.println("<empty stack>");
        }
        // display each values
        else {
            StringBuilder sb = new StringBuilder();
            for (Double value : stackValues) {
                sb.append(value.toString()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
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
    public void run() {
        Scanner scanner = new Scanner(System.in);
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
                // it's like pressing number operator
                state.setCurrentValue(input);
                // press enter to push value to stack
                new EnterOperator(state).execute();
            } else {
                // check if operator if not a number
                Operator operator = operators.get(input.toLowerCase());
                if (operator != null) {
                    operator.execute();
                } else {
                    System.out.println("Unknown command or operator: " + input);
                    continue;
                }
            }
            // display stack
            displayStack();
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
        calculator.run();
    }
}
