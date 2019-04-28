import java.util.Scanner;

public class QuickSort {


    public static void quickSort(Comparable[] a) {
        sort(a, 0, a.length - 1);
        print(a);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo) return;

        int j = patition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int patition(Comparable[] a, int lo, int hi) {
        int arrCount = hi - lo + 1;
        // 找基准值
        int mediumValue = median3(a,lo, lo + arrCount / 2, hi);
        exchange(a, mediumValue, lo);

        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        while (++i<hi && less(a[++i], v)) {
            if (i == hi) { exchange(a, lo, hi); return hi; }
        }

        while (less(v, a[--j])) {
            if (j == lo + 1) return lo;
        }

        while (i < j) {
            exchange(a, i, j);
            while (less(a[++i], v)) ;
            while (less(v, a[--j])) ;
        }

        exchange(a, lo, j);

        return j;

    }

    // 取出3个数的中间数做基准值
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void print(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Please input you want to test array:");
        Scanner sc = new  Scanner(System.in);
        Comparable[] arr = sc.nextLine().split(" ");
        quickSort(arr);

    }
}
