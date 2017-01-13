package CN.EDU.SEU.leetcode;

public class Solution_191 {
	public int hammingWeight(int n) {

		int count = 0;
		while (n != 0) {
			count ++;
			n = n & (n-1);
		}
		
		return count;

	}
}
