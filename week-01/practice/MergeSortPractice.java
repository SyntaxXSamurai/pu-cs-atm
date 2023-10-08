/**
 * @author Aiden Truong
 */

public class MergeSortPractice {
    private static String[] aux;

    public static void merge(String[] list, int low, int mid, int high, int difference) {
        int i = low;
        int j = mid;

        for (int k = 0; k < difference; k++) {
            if (i == mid) {
                aux[k] = list[j++];
            } else if (j == high) {
                aux[k] = list[i++];
            } else if (list[i].compareTo(list[j]) > 0) {
                aux[k] = list[i++];
            } else {
                aux[k] = list[j++];
            }
        }

        for (int k = 0; k < difference; k++) {
            list[low + k] = aux[k];
        }
    }

    public static void sort(String[] list) {
        aux = new String[list.length];
        sort(list, 0, list.length);
    }

    public static void sort(String[] list, int low, int high) {
        int difference = high - low;

        if (difference <= 1) {
            return;
        }

        int mid = low + difference / 2;
        sort(list, low, mid);
        sort(list, mid, high);
        merge(list, low, mid, high, difference);
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