package CN.EDU.SEU.leetcode;

public class Solution_172 {
	public int trailingZeroes(int n) {
		if (n < 5)
			return 0;
		return n / 5 + trailingZeroes(n / 5);
	}
	
	
	  public int trailingZeroes2(int n) {
	        long num = 5;
	        int five = 5;
	        int count = 0;
	        
	        while (num <= n) {
	            count +=(int) (n / num);
	            num = num * five;
	        }
	        return count;
	    }
}
