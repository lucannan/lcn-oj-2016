package CN.EDU.SEU.leetcode;

public class Solution_26 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 1) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int result = 1;
		int orginBegin = 0;
		int begin = 0;
		int end = nums.length - 1;
		int j = begin + 1;
		while (j <= end) {
			if (nums[begin] == nums[j]) {
				while (j < end && nums[begin] == nums[++j])
					;
				nums[++begin] = nums[j];
				begin = j;
			} else {
				result++;
				begin = j;
				j++;
			}
		}
		return 0;

	}
}
