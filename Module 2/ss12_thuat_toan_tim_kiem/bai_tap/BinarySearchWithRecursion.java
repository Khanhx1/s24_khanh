package ss12_thuat_toan_tim_kiem.bai_tap;

import java.util.Arrays;

public class BinarySearchWithRecursion {
    private static int binarySearch(int[] arr, int low, int hight, int value) {
        if (low <= hight) {
            int mid = (low + hight) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, low, mid - 1, value);
            } else {
                return binarySearch(arr, mid + 1, hight, value);
            }
        }
        return -1;
    }
    private static int[] sort(int[] arr) {
        int indexOfMin;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[indexOfMin] > arr[j]) {
                    indexOfMin = j;
                }
            }
            if(arr[i] != arr[indexOfMin]) {
                temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8,7,3,5,10,1,4,2,6,9};
        int[] sortArr = sort(arr);
        System.out.println(Arrays.toString(sortArr));
        System.out.println(binarySearch(sortArr, 0, arr.length - 1, 7));
    }
}
