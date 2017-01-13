package CN.EDU.SEU.leetcode;

public class Solution_292 {


	public boolean canWinNum(int n) {
		return n % 4 != 0; // lose at 4,8,12....
	}
	
	
	public boolean canWinNim2(int n) {
	    if(n <= 0)
	        throw new IllegalArgumentException();
	    if(n < 4)
	        return true;
	    boolean[] res = new boolean[n + 1];
	    res[0] = true;
	    res[1] = true;
	    res[2] = true;
	    res[3] = true;
	    for(int i = 4 ; i <= n ; i++)
	        res[i] = !(res[i - 1] && res[i - 2] && res[i - 3]);
	    return res[n];
	}
}
