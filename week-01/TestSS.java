/**
 * @author Aiden Truong
 */

public class TestSS {
    public static int search(String key, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].compareTo(key) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        int iWordsListLength = words.length;
        double dStart = System.currentTimeMillis() / 1000.0;

        for (int i = 0; i < 10 * words.length; i++) {
            String key = words[StdRandom.uniformInt(iWordsListLength)];

            if (search(key, words) == -1) {
                StdOut.println(key);
            }
        }

        double dNow = System.currentTimeMillis() / 1000.0;
        StdOut.println(Math.round(dNow - dStart) + " seconds");
    }
}