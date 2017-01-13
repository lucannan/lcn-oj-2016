package CN.EDU.SEU.leetcode;

public class Solution_283 {
	public void moveZeroes(int[] nums) {
	    int numZeros=0;
	    for(int i=0; i<nums.length; i++){
	        if(nums[i]==0) numZeros++;
	        else nums[i-numZeros]= nums[i];
	    }
	    for(int i= nums.length - numZeros; i<nums.length; i++) nums[i]=0;
	}
}
