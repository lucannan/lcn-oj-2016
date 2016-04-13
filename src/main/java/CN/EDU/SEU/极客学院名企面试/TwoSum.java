package CN.EDU.SEU.极客学院名企面试;

import org.junit.Test;

/**
 * 给定一个数组和一个数字    数组元素是升序
 * 找出数组中任意两个数相加等于这个数字的所有的序列
 * Created by LCN on 2016/4/13.
 */
public class TwoSum {
    public void printResult(int a, int b) {
        System.out.println("[" + a + "," + b + "]");
    }

    /**
     * 时间复杂度为O(N^2)
     * 空间复杂度为O(1)
     *
     * @param array
     * @param s
     */
    public void twoSum01(int[] array, int s) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == s) {
                    printResult(array[i], array[j]);
                    break;
                }
            }
        }
    }


    public void twoSum02(int[] array, int s) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == s) {
                printResult(array[i], array[j]);
                i++;
                j--;
            }
            if (array[i] + array[j] < s) {
                i++;
            }
            if (array[i] + array[j] > s) {
                j--;
            }
        }
    }

    @Test
    public void test01() {
        int[] array = {1, 3, 4, 5, 8, 9, 11};
        int sum = 13;
        twoSum02(array, sum);
    }


}
