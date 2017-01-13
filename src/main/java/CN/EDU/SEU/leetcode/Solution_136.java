package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_136 {
	public int singleNumber(int[] nums) {
		Hashtable<Integer, Integer> table = new Hashtable();

		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(nums[i]) == false) {
				table.put(nums[i], i);
			} else {
				table.remove(nums[i]);
			}
		}
		Enumeration<Integer> keys = table.keys();
		return keys.nextElement();

	}

	public int singleNumber2(int[] nums) {
		if (nums == null) {
			return -1;
		}
		int result = 0;
		for (int n : nums) {
			result = result ^ n;
		}
		return result;
	}
}
