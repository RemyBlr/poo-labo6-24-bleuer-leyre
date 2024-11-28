package calculator.util;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * A stack implementation.
 * The stack allows to push and pop elements of type T.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
public class Stack<T> {

    /**
     * Implementation of inner class Node
     * Purpose : store valid data for stack
     */
    private class Node {
        private final Node next;
        private final T data;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Implementation of inner class StackIterator
     * Purpose : travel on stack Top -> Bottom
     */
    public class StackIterator implements java.util.Iterator<T> {
        private Node currentNode;

        private StackIterator(Node start) {
            super();
            this.currentNode = start;
        }


        /**
         * Checks if next node is not null.
         *
         * @return true if next node is not null
         */
        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        /**
         * Iterates on current node.
         * Throws NoSuchElementException if there is no next node to iterate.
         *
         * @return new current node data
         */
        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in stack");
            }
            currentNode = currentNode.next;
            return currentNode.data;
        }
    }

    //Implementation of Stack
    private Node top;

    public Stack() {
        top = null;
    }

    /**
     * Get new StackIterator on stack.
     *
     * @return new StackIterator on stack
     */
    public StackIterator getIterator() {
        Node startNode = new Node(null, top);
        return new StackIterator(startNode);
    }

    /**
     * Checks if stack is empty.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Get size of stack.
     *
     * @return size of stack as int
     */
    public int size() {
        int size = 0;
        StackIterator current = getIterator();
        while (current.hasNext()) {
            size++;
            current.next();
        }
        return size;
    }



    /**
     * Push data on top of stack.
     * Prevent "CI: no recursive Stack" by creating a brand-new Node each time.
     */
    public void push(T data) {
        top = new Node(data, top);
    }

    /**
     * Pop data on top of stack.
     *
     * @return data on top of stack
     */
    public T pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is already empty.");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * Get stack as String.
     *
     * @return String with format : "e0 e1 ... eN"
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        StackIterator current = getIterator();
        while (current.hasNext()) {
            str.append(current.next());
            if (current.hasNext()) {
                str.append(" ");
            }
        }
        return "" + str;
    }

    /**
     * Get stack as array in place and as a return value.
     *
     * @param a array of T to fill
     * @return a
     */
    public T[] toArray(T[] a) {
        int s = size();
        if (a.length < s) {
            // Create new array of same type with correct size
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), s);
        }
        StackIterator current = getIterator();
        for (int i = 0; i < s; i++) {
            a[i] = current.next();
        }
        if (a.length > s) {
            // Set next elem to null if array is larger
            a[s] = null;
        }
        return a;
    }
}
