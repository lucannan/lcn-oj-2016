package CN.EDU.SEU.排序算法;

/**
 * Created by LCN on 2016/3/20.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 插入排序：
 * 如同人们整理桥牌一样，将每一张牌插入到其他已经有序的牌中的适当的位置
 * 在计算机实现的过程中，为了给插入的元素腾出空间，我们需要将其余的元素在插入之前向右移动
 */

/**
 * 特点：
 * 稳定
 * 空间复杂度O(1)
 * 时间复杂度O(n2)
 * 最差情况：反序，需要移动n*(n-1)/2个元素
 * 最好情况：正序，不需要移动元素
 */
public class Insertion {

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


    /**
     * 插入排序
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    @SuppressWarnings("ALL")
    public static void main(String[] args) {
        Integer[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));


        int[] b = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        Insertion.sort(b);
        System.out.println(Arrays.toString(b));
    }

}
