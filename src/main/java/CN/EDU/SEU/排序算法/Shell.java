package CN.EDU.SEU.排序算法;

import java.util.Arrays;

/**
 * Created by LCN on 2016/3/20.
 * <p>
 * 希尔排序：
 * 一种基于插入排序的排序算法
 * 思想：
 * 使数组中的任意间隔为h的元素都是有序的
 */


/**
 * 希尔排序：
 * 一种基于插入排序的排序算法
 * 思想：
 * 使数组中的任意间隔为h的元素都是有序的
 */

/**
 * 直接插入排序是稳定的；而希尔排序是不稳定的。
 直接插入排序更适合于原始记录基本有序的集合。
 希尔排序的比较次数和移动次数都要比直接插入排序少，当N越大时，效果越明显。
 在希尔排序中，增量序列gap的取法必须满足：最后一个步长必须是 1
 直接插入排序也适用于链式存储结构；希尔排序不适用于链式结构。
 */
public class Shell {
    /***********************************************************************
     * Helper sorting functions
     ***********************************************************************/
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***********************************************************************
     * Check if array is sorted - useful for debugging
     ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i - h])) return false;
        return true;
    }

    /**
     * 希尔排序
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
            }
            assert isHsorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
    }


    public static void sort(int[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j - h] > a[j]) {
                        int temp = a[j - h];
                        a[j - h] = a[j];
                        a[j] = temp;
                    }
                }
            }
            h /= 3;
        }
    }


    public static void main(String[] args) {
        Integer[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5,
                1, 3, 7, 0, 12, 32, 6565, 78, 43,
                32, 989, 65, 43, 323, 3443, 67768,
                979, 9, 5, 3};
        Shell.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {7, 8, 9, 10, 6, 4, 3, 7, 5,
                1, 3, 7, 0, 12, 32, 6565, 78, 43,
                32, 989, 65, 43, 323, 3443, 67768,
                979, 9, 5, 3};
        Shell.sort(b);
        System.out.println(Arrays.toString(b));
    }

}
