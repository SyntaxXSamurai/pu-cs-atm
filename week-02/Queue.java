import java.util.Iterator;

/**
 * @author Aiden Truong
 */

public class Queue<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int N = 0;

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    private class Node { 
        private Item item;
        private Node next;
    }

    public void enqueue(Item item) {
        Node secondlast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
        } else {
            secondlast.next = last; 
        }

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next; 
        N--;

        return item;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            // remove
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