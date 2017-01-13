package CN.EDU.SEU.leetcode;

public class Solution_27 {
	public int removeElement(int[] nums, int val) {
		int len = nums.length, num = 0;
		if (len == 0)
			return 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] != val) {
				nums[num++] = nums[i];
			}
		}
		return num;
	}
}
