package CN.EDU.SEU.leetcode;

public class Solution_07 {
	public int reverse(int x) {
		int modNum = 0;
		int divNum = 0;
		long newNum = 0;
		boolean positive = true;
		if(x < 0){
			positive = false;
			x = -x;
		}
		
		while(x > 0){
			modNum = x % 10;
			newNum = newNum * 10 + modNum;
			x /= 10;
		}
		
		if(!positive){
			newNum = - newNum;
		}
		
		if(newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE){
			return 0;
		}
		return (int) newNum;
	}
}
