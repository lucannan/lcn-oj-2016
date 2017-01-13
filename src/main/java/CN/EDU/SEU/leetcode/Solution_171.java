package CN.EDU.SEU.leetcode;

public class Solution_171 {
	public int titleToNumber(String s) {
		int num = 0;
		int len = s.length();
		char c = 0;
		for (int i = 0; i < len; i++) {
			c = s.charAt(len - i - 1);
			num += (int) Math.pow(26, i) * (c - 'A' + 1);
		}
		return num;
	}
}
