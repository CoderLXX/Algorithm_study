import java.util.Scanner;

public class BubbleSort {


    //从小到大自然排序
    public static <Key extends Comparable<Key>> void bubbleSort(Key[] array) {
        for (int i = 0; i < array.length; i++) {
            int exchangeNum = 0;
            for (int j = array.length - 1; j > i ; j--) {
                Key temp = array[i];
                if (array[i].compareTo(array[j]) > 0) {
                    array[i] = array[j];
                    array[j] = temp;
                    exchangeNum ++;
                }
            }
            if (exchangeNum == 0) {
                break;
            }
        }
        print(array);
    }

    private static void print(Comparable[] array) {
        for (Comparable item : array) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Please input a array, use space split each item");
        Scanner sc = new  Scanner(System.in);
        Comparable[] arr = sc.nextLine().split(" ");
        bubbleSort(arr);
    }
}
