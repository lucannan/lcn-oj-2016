package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/3/22.
 */

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
   You may assume that each input would have exactly one solution.
 */

/**
 * Given nums = [2, 7, 11, 15], target = 9,
   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 */
public class _001 {

    //Runtime: 145 ms
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if ((nums[i] + nums[j])==target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


    //Runtime: 5 ms
    public int[] twoSum2(int[] nums, int target) {
        int [] temNum = nums.clone();
        int length = nums.length;
        Arrays.sort(temNum);
        int min = 0, max = length - 1;
        while(true)
        {
            int count = temNum[min] + temNum[max];
            if(count > target)
            {
                max--;
            }
            else if(count < target)
            {
                min++;
            }
            else
            {
                break;
            }
        }
        int [] result = new int[2];
        for(int i=0,j=0;i<length;i++)
        {
            if(temNum[min] == nums[i] || temNum[max] == nums[i])
            {
                result[j] = i;
                j++;
            }
        }
        return result;
    }


}
