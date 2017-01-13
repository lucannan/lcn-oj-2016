package CN.EDU.SEU.leetcode;

public class Solution_389 {
	public char findTheDifference(String s, String t) {
	    
	    int num = 0;
	    for (char c : s.toCharArray()) {
	        num ^= (c - 'a');
	    }
	    
	    for (char c : t.toCharArray()) {
	        num ^= (c - 'a');
	    }
	    
	    return (char)('a' + num);
	}
}
