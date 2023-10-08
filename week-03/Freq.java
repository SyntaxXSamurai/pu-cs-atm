public class Freq {
    public static void main(String[] args) {
        BST<String, Integer> frequency = new BST<String, Integer>();

        while(!StdIn.isEmpty()) {
            String sKey = StdIn.readString();

            if(frequency.contains(sKey)) {
                frequency.put(sKey, frequency.get(sKey) + 1);
            } else {
                frequency.put(sKey, 1);
            }
        }

        for (String s : frequency.keys()) {
            StdOut.printf("%8d %s\n", frequency.get(s), s);
        }
    }
}