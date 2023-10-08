public class Sort {
    public static void main(String[] args) { 
        // Sort lines on StdIn
        BST<String, Integer> sort = new BST<String, Integer>();

        while (StdIn.hasNextLine()) {
            sort.put(StdIn.readLine(), 0);
        }

        for (String s : sort.keys()) {
            StdOut.println(s);
        }
    }
}                    