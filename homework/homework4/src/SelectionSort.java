import java.util.Scanner;

public class SelectionSort {


    // 排序从小到大自然排序
    public static void selectionSort(Comparable[] arr) {
        int arrCount = arr.length;
        int min;
        Comparable temp;
        for (int i = 0; i < arrCount - 1; i++) {
            min = i;
            temp = arr[i];
            for (int j = i + 1; j < arrCount; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
        print(arr);
    }


    private static void print(Comparable[] array) {
        for (Comparable item : array) {
            System.out.print(item + " ");
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        System.out.println("please input array:");
        Scanner sc = new  Scanner(System.in);
        Comparable[] arr = sc.nextLine().split(" ");
        selectionSort(arr);
    }
}
