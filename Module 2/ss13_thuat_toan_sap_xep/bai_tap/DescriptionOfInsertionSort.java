package ss13_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class DescriptionOfInsertionSort {
    public static void main(String[] args) {
        int[] arr = {2,5,6,7,3,10,16,4,19};
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
            System.out.println("Array ater loop " + i + " time(s) :" + Arrays.toString(arr));
        }
        System.out.println("-------Array after sort: ");
        System.out.println(Arrays.toString(arr));
    }
}
