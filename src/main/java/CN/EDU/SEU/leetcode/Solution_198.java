package CN.EDU.SEU.leetcode;

public class Solution_198 {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		for (int i = 2; i < nums.length; i++) {
			nums[i] += i == 2 ? nums[0] : Math.max(nums[i - 2], nums[i - 3]);
		}

		return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
	}
}
