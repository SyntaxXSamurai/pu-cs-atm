import java.util.Arrays;

/**
 * @author Aiden Truong
 */

public class BinarySearch {
    public static int search(String key, String[] list) {
        return search(key, list, 0, list.length);
    }

    public static int search(String key, String[] list, int low, int high) {
        if (high <= low) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int BinaryCheck = list[mid].compareTo(key);
        if (BinaryCheck > 0) {
            return search(key, list, low, mid); 
        } else if (BinaryCheck < 0) {
            return search(key, list, mid + 1, high);
        } else {
            return mid; 
        }
    }

    public static void main(String[] args) {
        In file = new In(args[0]);
        String[] list = file.readAllStrings();
        Arrays.sort(list);

        String key = "";
        while (!StdIn.isEmpty()) {
            key = StdIn.readString();

            if (search(key, list) != -1) {
                StdOut.println(key);
            }
        }
    } 
}