/**
 * @author Aiden Truong
 */

public class Validate {
    public static void main(String[] args) {
        String re = args[0];

        String text = "";
        while (!StdIn.isEmpty()) {
            text = StdIn.readString();

            if (text.matches(re)) {
                StdOut.println("true");
            } else {
                StdOut.println("false");
            }
        }
    }
}