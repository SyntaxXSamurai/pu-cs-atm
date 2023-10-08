/**
 * @author Aiden Truong
 */

public class InsertionSortPractice {
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

    public static void change(String[] list, int lowest, int highest) {
        String lowerListWord = list[lowest];
        list[lowest] = list[highest];
        list[highest] = lowerListWord;
    }

    public static void main(String[] args) {
        In file = new In(args[0]);
        String[] list = file.readAllStrings();
        sort(list);

        for (int i = 0; i < list.length; i++) {
            StdOut.println(list[i]);
        }
    }
}