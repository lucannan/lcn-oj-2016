package CN.EDU.SEU.leetcode;

public class Solution_397 {
	   public int integerReplacement(int n) {
	        if(n == 1)  return 0;
	        if(n %2 == 0)   return 1 + integerReplacement(n >>> 1);
	        if(n == 3 || (n & 3) == 1)  return 1 + integerReplacement(n-1);
	        return 1 + integerReplacement(n+1);
	    }
}
