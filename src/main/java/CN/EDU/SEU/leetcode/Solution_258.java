package CN.EDU.SEU.leetcode;

public class Solution_258 {
	public int addDigits(int num) {
		int g = 0;
		while (num > 0) {
			g = g + num % 10;
			num = num / 10;
		}
		if (g >= 10) {
			g = addDigits(g);
		}
		return g;
	}
}
