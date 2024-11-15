package calculator.util;

import java.lang.reflect.Array;

public class Stack<T> {
    public class Node{
        private Node next;
        private final T data;

        private Node(T data, Node next) {
            this.data = data;
            setNext(next);
        }

        private void setNext(Node next) {
            if (next != this) {
                this.next = next;
            }
            else {
                throw new IllegalArgumentException("Node next cannot be ones self!");
            }
        }

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
    public T pop() {
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

    public T[] toArray() {
        if (isEmpty()) {
            return null;
        }
        int s = size();
        //Might induce panic attacks :
        T[] r = (T[]) Array.newInstance(top.data.getClass(), s);
        Node current = top;
        for (int i = 0; i < s; i++) {
            r[i] = current.data;
            current = current.next;
        }
        return r;
    }

    //is a node a good iterator?
    public Node getIterator() {
        return top;
    }
}
