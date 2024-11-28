package calculatorTest;

import static org.junit.jupiter.api.Assertions.*;
import calculator.util.Stack;

/**
 * Test of behavior of Stack
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
class StackTest {

    @org.junit.jupiter.api.Test
    void popTest(){
        Stack<Double> stack = new Stack<>();
        RuntimeException thrown = assertThrows(RuntimeException.class, stack::pop,
                "Stack is already empty.");
    }

    @org.junit.jupiter.api.Test
    void pushAndArrayTest(){
        Stack<Double> stack = new Stack<>();
        stack.push(2.0);
        stack.push(2.0);
        Double[] result = new Double[stack.size()];
        Double[] expected = {2.0,2.0};
        assertArrayEquals(expected,stack.toArray(result));
        assertArrayEquals(expected,result);
    }

    @org.junit.jupiter.api.Test
    void StackIteratorTest(){
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        Stack.StackIterator it = stack.getIterator();
        assertTrue(it.hasNext());
        assertEquals(3.0,it.next());
        assertEquals(2.0,it.next());
        assertTrue(it.hasNext());
        assertEquals(1.0,it.next());
        assertFalse(it.hasNext());
    }

    @org.junit.jupiter.api.Test
    void StackToStringTest(){
        Stack<Double> stack = new Stack<>();
        assertEquals(stack.toString(),"");
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        assertEquals(stack.toString(),"3.0 2.0 1.0");
    }
}
