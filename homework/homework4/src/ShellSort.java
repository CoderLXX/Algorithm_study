import java.util.Scanner;

public class ShellSort {

    static void shellSort(Comparable[] arr) {
        int arrCount = arr.length;
        int number = 1;

        while (number < arrCount / 3) {
            number = 3 * number + 1;
        }

        while (number >= 1) {
            for (int i = number; i < arrCount; i++) {
                for (int j = i; j >= number && less(arr[j], arr[j - number]); j -= number) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j - number];
                    arr[j - number] = temp;
                }
            }
            number = number / 3;
        }
        print(arr);
    }

    static void print(Comparable[] a) {
        for (Comparable item :
                a)  {
            System.out.print(item + " ");
        }
    }

    static boolean less(Comparable a, Comparable b) {
        return  a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        System.out.println("Please input an array to test my shell sort:");
        Scanner sc = new  Scanner(System.in);
        Comparable[] arr = sc.nextLine().split(" ");
        shellSort(arr);

    }

}
