package CN.EDU.SEU.查找算法;

/**
 * Created by LCN on 2016/3/21.
 */
public class BinarySearch {
    /**
     * description : 二分查找。
     *
     * @param <E>
     * @param array 需要查找的有序数组
     * @param from  起始下标
     * @param to    终止下标
     * @param key   需要查找的关键字
     * @return
     * @throws Exception
     */
    public static <E extends Comparable<E>> int binarySearch(E[] array, int from, int to, E key) {
        if (from > to) return -1;

        int middle = (from + to) >>> 1; // 右移即除2   >>> 无符号右移
        E temp = array[middle];
        if (temp.compareTo(key) > 0) {
            to = middle - 1;
            return binarySearch(array, from, to, key);
        } else if (temp.compareTo(key) < 0) {
            from = middle + 1;
            return binarySearch(array, from, to, key);
        } else {
            return middle;
        }

    }

    /**
     * 非递归的形式
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                26, 27, 28, 29, 30, 31, 32, 33};

        int index = BinarySearch.binarySearch(a, 0, a.length - 1, 17);

        System.out.println(index);
    }
}
