import java.util.Scanner;

public class InsertionSort {


    static void insertSort(Comparable[] arr) {
        int arrCount = arr.length;
        for (int i = 0; i < arrCount; i++) {
            Comparable currentValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(currentValue) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
        printArray(arr);
    }


    static void printArray(Object[] arr) {
        for (Object item :
                arr) {
            System.out.print(item + " ");
        }
    }


    public static void main(String[] args) {
        System.out.println("please input your want to sort array:");
        Scanner sc = new  Scanner(System.in);
        Comparable[] arr = sc.nextLine().split(" ");
        insertSort(arr);

    }
}
