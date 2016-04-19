package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 调整数组顺序使奇数位于偶数前面
 * Created by LCN on 2016/4/19.
 */
public class Test14 {

    public static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test01() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }
}
