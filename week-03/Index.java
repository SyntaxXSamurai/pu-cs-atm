public class Index {
    public static void main(String[] args) {
        BST<String, Queue<Integer>> index = new BST<String, Queue<Integer>>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();

            if (!index.contains(key)) {
                index.put(key, new Queue<Integer>());
            }
            index.get(key).enqueue(i);
        }

        for (String s : index.keys()) {
            StdOut.print(s + " ");
            for (int i : index.get(s)) {
                StdOut.print(i + " ");
            }

            StdOut.println();
        }
    }
}