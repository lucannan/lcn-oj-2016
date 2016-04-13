package CN.EDU.SEU.leetcode;

import java.util.ArrayList;

/**
 * 去除一个有序数组中的重复元素
 * Created by LCN on 2016/4/13.
 */
public class __026RemoveDuplicates {
    /**
     * 借助ArrayList解决问题
     * 空间复杂度O(N)
     */
    public int remove01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int end = nums.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i <= end) {
            if (i == end) {
                list.add(nums[i]);
                i++;
            } else {
                int j = i + 1;
                if (nums[i] == nums[j]) {
                    while (j <= end && nums[i] == nums[j]) {
                        j++;
                    }
                }
                list.add(nums[i]);
                i = j;
            }
        }

        for (int j = 0; j < list.size(); j++) {
            nums[j] = list.get(j);
        }
        return list.size();
    }


    /**
     * 模拟System.arraycopy()
     *
     * @param array1 源数组
     * @param s1     源数组的开始位置
     * @param array2 目标数组
     * @param s2     目标数组的开始位置
     * @param len    需要复制的元素的个数
     */
    public void myArrayCopy(int[] array1, int s1, int[] array2, int s2, int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = array1[s1 + i];
        }
        for (int i = 0; i < len; i++) {
            array2[s2 + i] = array[i];
        }
    }

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(N)
     * 借助ArrayCopy解决问题
     */
    public int remove02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int end = nums.length - 1;
            for (int i = 0; i <= end; i++) {
                if (i < end) {
                    int j = i + 1;
                    if (nums[i] == nums[j]) {
                        while (j <= end && nums[i] == nums[j]) {
                            j++;
                        }
                    }
                    System.arraycopy(nums, j, nums, i + 1, end - j + 1);
                    //用myArrayCopy 有时候Accepted，有时候 Time limit exceeded
                    //同学们可以多提交几次，估计是判题系统的问题
                    //myArrayCopy(nums, j, nums, i+1, end-j+1);
                    end -= j - i - 1;
                }
            }
            return end + 1;
        }
    }

    /**
     * 借助临时变量解决问题
     * 空间复杂度O(1)
     * 时间复杂度O(N)
     */
    public int remove03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int temp = nums[0];
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (temp == nums[i]) {
                    continue;
                } else {
                    temp = nums[i];
                    nums[len] = nums[i];
                    len++;
                }
            }
            return len;
        }
    }

}
