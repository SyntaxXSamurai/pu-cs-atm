import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Aiden Truong
 */

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public void push(Item item) {
        Node second = first;
        first = new Node();

        first.item = item;
        first.next = second;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;

        return item;
    }

    public boolean isEmpty() {
        return (N == 0) || (first == null);
    }

    public int size() {
        return N;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() { 
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { 
            return (current != null);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("-")) {
                StdOut.print(stack.pop() + " ");
            } else {
                stack.push(item);
            }
        }

        StdOut.println();
        StdOut.println(stack.size());
    }
}