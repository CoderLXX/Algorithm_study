import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        sort(arr, result, 0, length - 1);
        print(arr);
    }

    private static void sort(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;

        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        sort(arr, result, start1, end1);
        sort(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2]? arr[start1++]: arr[start2++];
        }

        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }

        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }

        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    private static void print(int[] a) {
        for (int item :
                a) {
            System.out.print(item + " ");
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{994, 0, 727, 15, 32, 76};
        mergeSort(a);
    }
}
