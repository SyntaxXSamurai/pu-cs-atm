/**
 * @author Aiden Truong
 */

public class InsertionSort {
    public static void sort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j - 1].compareTo(list[j]) > 0) {
                    change(list, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void change(String[] list, int lower, int greater) {
        String sListWord = list[lower];
        list[lower] = list[greater];
        list[greater] = sListWord;
    }

    public static void main(String[] args) {
        String[] list = StdIn.readAllStrings();
        sort(list);

        for (int i = 0; i < list.length; i++) {
            StdOut.println(list[i]);
        }
    }
}