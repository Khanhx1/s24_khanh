package ss13_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSortArray(int[] arr) {
        int x;
        int pos;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos -1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,7,3,10,16,4,19};
        insertionSortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
