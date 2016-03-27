package CN.EDU.SEU.程序员面试经典.递归和动态规划;

/**
 * p224
 * 在数组A[0...N-1]中，有所谓的魔术索引，满足A[i] = i。给定一个有序整数序列整数数组，元素各不相同，编写一个方法，在数组
 * A中找出一个魔术索引
 * Created by LCN on 2016/3/27.
 */
public class __9_3MagicIndex {

    /**
     * 暴力方法   有序   元素各不重复
     *
     * @param array
     * @return
     */
    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 通过二分索引
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int magicFast(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }


    /**
     * 数组中的元素有重复值
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int magicFast2(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        //搜索左半部分
        int leftIndex = Math.max(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);

        if (right >= 0) {
            return right;
        }
        return -1;
    }


}
