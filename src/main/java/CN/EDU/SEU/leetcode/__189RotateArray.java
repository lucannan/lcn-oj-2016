package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/4/13.
 */
public class __189RotateArray {
    public static void rotate(int[] num, int start, int end) {
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        rotate(nums, nums.length - 1 - k + 1, nums.length - 1);
        rotate(nums, 0, nums.length - 1 - k);
        rotate(nums, 0, nums.length - 1);
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        rotate(data, 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
