package CN.EDU.SEU.排序算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by LCN on 2016/3/20.
 */
public class BubbleSort {

    /***********************************************************************
     * Helper sorting functions
     ***********************************************************************/
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // is v < w ?
    private static boolean less(Comparator c, Object v, Object w) {
        return (c.compare(v, w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***********************************************************************
     * Check if array is sorted - useful for debugging
     ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i - 1])) return false;
        return true;
    }


    public static void BubbleSort(Comparable[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[i])) {
                    exch(arr, i, j);
                }
            }
        }
    }


    //not a real bubble sort
    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    // a real bubble sort
    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void bubbleSort3(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void bubbleSort4(int[] arr) {
        int n = arr.length;
        boolean flag = true;

        for (int i = 0; i < n - 1 && flag; i++) {
            flag = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Integer[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        BubbleSort.BubbleSort(a);
        System.out.println(Arrays.toString(a));


        int[] b = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        BubbleSort.bubbleSort4(b);
        System.out.println(Arrays.toString(b));
    }
}
