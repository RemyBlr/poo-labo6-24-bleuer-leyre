package calculator.util;

import calculator.BinaryOperator;

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
    public class Node{
        private Node next;
        private final T data;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        // not correct way to set next, should be in Iterator
        /*private void setNext(Node next) {
            if (next != this) {
                this.next = next;
            }
            else {
                throw new IllegalArgumentException("Node next cannot be ones self!");
            }
        }*/

        public boolean hasNext() {
            return next != null;
        }

        //T?
        public T next() {
            if (hasNext()) {
                return next.data;
            }
            return null;
        }
    }

    private Node top;

    public Stack() {
        top = null;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public void push(T data) {
        top = new Node(data, top);
    }
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public String toString() {
        String str = "[";
        Node current = top;
        while (current != null) {
            str += current.data;
            current = current.next;
            if (current != null) {
                str += ", ";
            }
        }
        return str + "]";
    }

    public T[] toArray(T[] a) {
        int s = size();
        if (a.length < s) {
            // Create new array of same type with correct size
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), s);
        }
        Node current = top;
        for (int i = 0; i < s; i++) {
            a[i] = current.data;
            current = current.next;
        }
        if (a.length > s) {
            // Set next elem to null if array is larger
            a[s] = null;
        }
        return a;
    }

    //is a node a good iterator?
    public Node getIterator() {
        return top;
    }

    /*public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<T> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in stack");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }*/
}
