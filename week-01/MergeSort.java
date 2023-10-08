/** 
 * @author Aiden Truong
 */

 public class MergeSort {
    private static String[] aux;

    public static void merge(String[] list, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int iDif = high - low;

        for (int k = 0; k < iDif; k++) {
            if (i == mid) {
                aux[k] = list[j++];
            } else if (j == high) {
                aux[k] = list[i++];
            } else if (list[j].compareTo(list[i]) < 0) {
                aux[k] = list[j++];
            } else {
                aux[k] = list[i++];
            }
        }

        for (int k = 0; k < iDif; k++) {
            list[low + k] = aux[k]; 
        }
    }

    public static void sort(String[] list) {
        aux = new String[list.length];
        sort(list, 0, list.length);
    }

    public static void sort(String[] list, int low, int high) {
        int iDif = high - low;

        if (iDif <= 1) {
            return;
        }
        
        int iMid = low + iDif / 2;
        sort(list, low, iMid);
        sort(list, iMid, high);
        merge(list, low, iMid, high);
    }

    public static void main(String[] args) {
        String[] list = StdIn.readAllStrings();
        sort(list);

        for (int i = 0; i < list.length; i++) {
            StdOut.println(list[i]);
        }
    }
 }