package CN.EDU.SEU.leetcode;

public class Solution_231 {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}
}
