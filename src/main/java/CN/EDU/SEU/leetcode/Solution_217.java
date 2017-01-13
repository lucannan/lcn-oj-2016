package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_217 {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1)
			return false;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] == nums[i + 1])
				return true;

		return false;
	}
	
	
	public boolean containsDuplicate2(int[] nums) {
		 Set<Integer> set = new HashSet<Integer>();
		 for(int i : nums)
			 if(!set.add(i))// if there is same
				 return true; 
		 return false;
	}
	
	

}
