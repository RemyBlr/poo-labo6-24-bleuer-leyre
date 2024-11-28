package calculatorTest;

import static org.junit.jupiter.api.Assertions.*;
import calculator.Calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Test of behavior of Calculator
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
public class CalculatorTest {

    @org.junit.jupiter.api.Test
    void additionTest() {
        Calculator calculator = new Calculator();

        //basic addition
        String[] in1 = {"2", "2", "+", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("4.0", calculator.displayState());

        //default state addition
        String[] in2 = {"c", "+", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("Error", calculator.displayState());

        //default state 2.0 addition
        String[] in3 = {"c", "2", "+", "exit"};
        InputStream input3 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in3)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input3);
        assertEquals("Error", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void subtractionTest() {
        Calculator calculator = new Calculator();

        //basic subtraction
        String[] in1 = {"1", "2", "-", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("-1.0", calculator.displayState());

        //default state subtraction
        String[] in2 = {"c", "-", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("Error", calculator.displayState());

        //default stacked 2.0 subtraction
        String[] in3 = {"c", "2", "-", "exit"};
        InputStream input3 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in3)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input3);
        assertEquals("Error", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void MultiplicationTest() {
        Calculator calculator = new Calculator();

        //basic Multiplication
        String[] in1 = {"1", "2", "*", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("2.0", calculator.displayState());

        //Multiplication by float
        String[] in2 = {"c", "3", "0.125", "*", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("0.375", calculator.displayState());

        //Multiplication reasonable large float handling(no overflow)
        String[] in3 = {"c", "1", "0.12522222222222222222222222222222222", "*", "exit"};
        InputStream input3 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in3)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input3);
        assertEquals("0.12522222222222223", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void DivisionTest() {
        Calculator calculator = new Calculator();

        //basic Division
        String[] in1 = {"2", "2", "/", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("1.0", calculator.displayState());

        //Division by float
        String[] in2 = {"c", "3", "0.125", "/", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("24.0", calculator.displayState());

        //Division by 0
        String[] in3 = {"c", "3", "0", "/", "exit"};
        InputStream input3 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in3)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input3);
        assertEquals("Error", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void SquareRootTest() {
        Calculator calculator = new Calculator();

        //basic SquareRoot
        String[] in1 = {"4", "sqrt", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("2.0", calculator.displayState());

        //SquareRoot of négative
        String[] in2 = {"c", "-4", "sqrt", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("Error", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void ReciprocalTest() {
        Calculator calculator = new Calculator();

        //basic Reciprocal
        String[] in1 = {"4", "1/x", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("0.25", calculator.displayState());

        //Reciprocal of 0
        String[] in2 = {"c", "0", "1/x", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("Error", calculator.displayState());

        //Reciprocal of float
        String[] in3 = {"c", "0.25", "1/x", "exit"};
        InputStream input3 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in3)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input3);
        assertEquals("4.0", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void SquareTest() {
        Calculator calculator = new Calculator();

        //basic Square
        String[] in1 = {"2", "x^2", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("4.0", calculator.displayState());

        //Square of negative
        String[] in2 = {"c", "-2", "x^2", "exit"};
        InputStream input2 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in2)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input2);
        assertEquals("4.0", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void ChangeSignTest() {
        Calculator calculator = new Calculator();

        //basic ChangeSign
        String[] in1 = {"-2", "+/-", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("2.0", calculator.displayState());
    }

    @org.junit.jupiter.api.Test
    void miscTest() {
        Calculator calculator = new Calculator();

        //memory swaperou
        String[] in1 = {"-2", "ms", "-1.5", "*", "0", "mr", "-", "exit"};
        InputStream input1 = new ByteArrayInputStream(String.join(System.lineSeparator(),
                Arrays.asList(in1)).getBytes(StandardCharsets.UTF_8));
        calculator.run(input1);
        assertEquals("5.0", calculator.displayState());
    }
}
