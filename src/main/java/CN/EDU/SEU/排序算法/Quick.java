package CN.EDU.SEU.排序算法;

/**
 * Created by LCN on 2016/3/20.
 */

import java.util.Arrays;

/**
 * 快速排序
 * 不稳定。
 * 空间复杂度：O(nlog2n)
 * 时间复杂度：O(nlog2n).............................................................
 * 最坏情况：O(n2)，要排序数组基本有序，基准值每次取最大（最小）元素，退化为冒泡。
 * 最好情况：O(nlog2n) 基准值两边元素个数基本相同.
 * 平均情况：O(nlog2n)
 */
public class Quick {
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
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**
     * Rearranges the array so that a[k] contains the kth smallest key;
     * a[0] through a[k-1] are less than (or equal to) a[k]; and
     * a[k+1] through a[N-1] are greater than (or equal to) a[k].
     *
     * @param a the array
     * @param k find the kth smallest
     */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
//        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }


    /********************************************************************/
    private static void quicksort(int[] n, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    private static int partition(int[] n, int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    /********************************************************************/
    public static int division(int[] list, int left, int right) {
        // 以最左边的数(left)为基准
        int base = list[left];
        while (left < right) {
            // 从序列右端开始，向左遍历，直到找到小于base的数
            while (left < right && list[right] >= base)
                right--;
            // 找到了比base小的元素，将这个元素放到最左边的位置
            list[left] = list[right];

            // 从序列左端开始，向右遍历，直到找到大于base的数
            while (left < right && list[left] <= base)
                left++;
            // 找到了比base大的元素，将这个元素放到最右边的位置
            list[right] = list[left];
        }

        // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        list[left] = base;
        return left;
    }

    private static void quickSort2(int[] list, int left, int right) {
        // 左下标一定小于右下标，否则就越界了
        if (left < right) {
            //对数组进行分割，取出下次分割的基准标号
            int base = division(list, left, right);

            //对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort2(list, left, base - 1);

            //对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort2(list, base + 1, right);
        }
    }


    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5,
                1, 3, 7, 0, 12, 32, 6565, 78, 43,
                32, 989, 65, 43, 323, 3443, 67768,
                979, 9, 5, 3};

        int[] b = {7, 8, 9, 10, 6, 4, 3, 7, 5,
                1, 3, 7, 0, 12, 32, 6565, 78, 43,
                32, 989, 65, 43, 323, 3443, 67768,
                979, 9, 5, 3};
        Quick.quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        System.out.println("======================");
        System.out.println(Arrays.toString(b));
        Quick.quickSort2(b, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }
}
