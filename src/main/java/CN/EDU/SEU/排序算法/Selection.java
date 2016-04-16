package CN.EDU.SEU.排序算法;

/**
 * Created by LCN on 2016/3/20.
 * <p>
 * 选择排序算法：
 * 首先,找到数组中最小的那个元素,其次,将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)
 * 再次,在剩下的元素中找到最小的元素,将它和数组的第二个元素进行交换。如此反复
 * <p>
 * 算法特点：
 * 此方法移动元素的次数比较少，但是不管序列中元素初始排列状态如何，第 i 趟排序都需要进行 n - i 次元素之间的比较，
 * 因此总的比较次数为1 + 2 + 3 + 4 +5 + . . . + n - 1 = n(n-1)/2, 时间复杂度是 O(n^2)
 * <p>
 * 不稳定
 * 空间复杂度：O(1)
 * 时间复杂度：O(n2)
 * 最坏情况：O(n2) 第一个元素为最大元素，其余元素正序，需要交换n-1个元素（如：4 3 2 1）
 * 最好情况：O(n2) 正序，不需要交换元素
 * <p>
 * 选择排序算法：
 * 首先,找到数组中最小的那个元素,其次,将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)
 * 再次,在剩下的元素中找到最小的元素,将它和数组的第二个元素进行交换。如此反复
 * <p>
 * 算法特点：
 * 此方法移动元素的次数比较少，但是不管序列中元素初始排列状态如何，第 i 趟排序都需要进行 n - i 次元素之间的比较，
 * 因此总的比较次数为1 + 2 + 3 + 4 +5 + . . . + n - 1 = n(n-1)/2, 时间复杂度是 O(n^2)
 * <p>
 * 不稳定
 * 空间复杂度：O(1)
 * 时间复杂度：O(n2)
 * 最坏情况：O(n2) 第一个元素为最大元素，其余元素正序，需要交换n-1个元素（如：4 3 2 1）
 * 最好情况：O(n2) 正序，不需要交换元素
 */

/**
 * 选择排序算法：
 * 首先,找到数组中最小的那个元素,其次,将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)
 * 再次,在剩下的元素中找到最小的元素,将它和数组的第二个元素进行交换。如此反复
 */

/**
 * 算法特点：
 * 此方法移动元素的次数比较少，但是不管序列中元素初始排列状态如何，第 i 趟排序都需要进行 n - i 次元素之间的比较，
 * 因此总的比较次数为1 + 2 + 3 + 4 +5 + . . . + n - 1 = n(n-1)/2, 时间复杂度是 O(n^2)
 *
 *  不稳定
 空间复杂度：O(1)
 时间复杂度：O(n2)
 最坏情况：O(n2) 第一个元素为最大元素，其余元素正序，需要交换n-1个元素（如：4 3 2 1）
 最好情况：O(n2) 正序，不需要交换元素
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Selection {
    /***********************************************************************
     *  Helper sorting functions
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

    /***********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // is the array a[] sorted?
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
     * 选择排序
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;                     //数组长度
        for (int i = 0; i < N; i++) {
            int min = i;                     //将a[i]和a[i+1...N]中最小的元素交换
            for (int j = i + 1; j < N - 1; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) min = j;
            }
            //交换位置
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }


    @SuppressWarnings("ALL")
    public static void main(String[] args) {
        Integer[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {7, 8, 9, 10, 6, 4, 3, 7, 5, 3};
        Selection.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
