/**
 * @author Robert Sedgewick
 */

public class WhiteFilter {
    public static int search(String key, String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(key) == 0) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        In file = new In(args[0]);
        String[] words = file.readAllStrings();

        String key = "";
        while (!StdIn.isEmpty()) {
            key = StdIn.readString();

            if (search(key, words) != -1) {
                StdOut.println(key);
            }
        }
    } 
}