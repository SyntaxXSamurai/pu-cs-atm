import java.util.Arrays;

/**
 * @author Aiden Truong
 */

public class BinarySearchPractice {
    public static int search(String[] list, String key) {
        return search(list, key, 0, list.length);
    }

    public static int search(String[] list, String key, int low, int high) {
        if (high <= low) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int search = list[mid].compareTo(key);
        if (search > 0) {
            return search(list, key, low, mid);
        } else if (search < 0) {
            return search(list, key, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        In file = new In(args[0]);
        String[] searchList = file.readAllStrings();
        Arrays.sort(searchList);

        String key = "";
        while (!StdIn.isEmpty()) {
            key = StdIn.readString();

            if (search(searchList, key) != -1) {
                StdOut.println(key);
            }
        }
    }
}