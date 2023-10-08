/**
 * @author Aiden Truong
 */

public class StrawStack {
    private String[] stacklist;
    private int N = 0;

    public void push (String item) {
        stacklist[N++] = item;
    }

    public String pop() {
        return stacklist[--N];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N;
    }

    public StrawStack(int max) {
        stacklist = new String[max];
    }

    public static void main(String[] args) {
        int iMax = Integer.parseInt(args[0]);
        StrawStack stack = new StrawStack(iMax);

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