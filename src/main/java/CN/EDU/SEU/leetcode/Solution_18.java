package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return result;
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) { // 4sum
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip
			int target1 = target - nums[i];
			for (int j = i + 1; j < len - 2; j++) { // 3sum
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue; // skip
				int target2 = target1 - nums[j];
				int k = j + 1, m = len - 1;
				while (k < m) { // 2sum
					if (nums[k] + nums[m] == target2) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
						while (k < m && nums[k + 1] == nums[k])
							k++; // skip
						while (k < m && nums[m - 1] == nums[m])
							m--; // skip
						k++;
						m--;
					} else if (nums[k] + nums[m] < target2)
						k++;
					else
						m--;

				}
			}
		}
		return result;
	}
}
