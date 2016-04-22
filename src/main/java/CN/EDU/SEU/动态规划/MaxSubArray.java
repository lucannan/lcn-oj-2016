package CN.EDU.SEU.动态规划;

import org.junit.Test;

/**
 * 最大子串乘积
 * Created by LCN on 2016/4/22.
 */
public class MaxSubArray {

    public static int maxSubArray(int[] data) {
        if (data.length == 0)
            return 0;
        int[] maxcurr = new int[data.length];
        int[] mincurr = new int[data.length];

        for (int i = 0; i < maxcurr.length; i++) {
            maxcurr[i] = 0;
        }
        for (int i = 0; i < mincurr.length; i++) {
            mincurr[i] = 0;
        }
        maxcurr[0] = data[0];
        mincurr[0] = data[0];

        int maxResult = data[0];

        for (int i = 1; i < data.length; i++) {
            maxcurr[i] = Math.max(data[i], Math.max(maxcurr[i - 1] * data[i], mincurr[i - 1] * data[i]));
            mincurr[i] = Math.min(data[i], Math.min(mincurr[i - 1] * data[i], maxcurr[i - 1] * data[i]));
            maxResult = Math.max(maxcurr[i], maxResult);
        }
        return maxResult;
    }


    /**
     * 数组中连续子数组和最大
     *
     * @param data
     * @return
     */
    public static int maxSubArray2(int[] data) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < data.length; i++) {
            int sum = 0;
            for (int j = i; j < data.length; j++) {
                sum += data[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }

        }
        return maxSum;
    }


    /**
     * 动态规划解法
     *
     * @param data
     * @return
     */
    public static int maxSubArray3(int[] data) {
        if (data == null) {
            return 0;
        }
        int currentSum = data[0];
        int maxSum = data[0];
        int pos = 0;

        int left = 0;
        int right = 0;
        for (int i = 1; i < data.length; i++) {
            currentSum += data[i];
            if (currentSum < data[i]) {
                pos = i;
                currentSum = data[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                left = pos;
                right = i;
            }
        }

        return maxSum;
    }

    @Test
    public void test02() {
        int[] data = {1, 4, -5, 8, 3};

        System.out.println(maxSubArray2(data));
    }

    @Test
    public void test01() {
        int[] data = {2, 3, -2, 4};
        System.out.println(maxSubArray(data));
    }
}
