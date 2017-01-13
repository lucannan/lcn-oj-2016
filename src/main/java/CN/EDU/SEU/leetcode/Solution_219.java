package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// create the hashtable
		Hashtable<Integer, Integer> table = new Hashtable();
		int length = nums.length;

		for (int i = 0; i < length; i++) {
			Integer position = 0;
			if ((position = table.get(nums[i])) == null) {
				table.put(nums[i], i);
			} else {
				if (i - position <= k)
					return true;

				table.put(nums[i], i);

			}
		}
		return false;
	}
}
