import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Aiden Truong
 */

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public void enqueue(Item item) {
        Node secondLast = last;
        last = new Node();
        
        last.item = item;
        last = secondLast.next;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (first == null) {
            first = last;
        }

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
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("-")) {
                queue.dequeue();
            } else {
                queue.enqueue(item);
            }
        }

        StdOut.println("Testing Iterable: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        
        StdOut.println();
        StdOut.println("Finish Testing Iterable");
        // StdOut.println(queue.size());
    }
}